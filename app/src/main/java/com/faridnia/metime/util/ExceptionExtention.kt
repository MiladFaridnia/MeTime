package com.faridnia.metime.util

import com.faridnia.metime.data.remote.dto.error.ErrorDetail
import com.faridnia.metime.data.remote.dto.error.ErrorDto
import com.faridnia.metime.data.remote.dto.error.SimpleErrorDto
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException
import java.net.ProtocolException
import java.net.SocketTimeoutException

fun Exception.extractErrorMessageFromResponse(): String {
    when (this) {
        is HttpException -> {
            when {

                code() == 400 || code() == 500 || code() == 422 || code() == 401-> {
                    return handleServerErrors()
                }

                code() == 404 -> {
                    return handleServerErrors()//"Requested page is not available"
                }

                code() == 403 -> {
                    return handle403Errors()
                }

            }
        }

        is SocketTimeoutException -> {
            return "Timeout"
        }

        is ProtocolException -> {
            return Constants.DEFAULT_ERROR
        }

        is IOException -> {
            return "Couldn't reach server. Check your internet connection."
        }

        else -> {
            return this.message ?: Constants.DEFAULT_ERROR
        }
    }

    return Constants.DEFAULT_ERROR
}

fun HttpException.handle403Errors(): String {
    val errorBody = this.response()?.errorBody()?.string()
    val gson = Gson()
    val errorResponse = try {
        gson.fromJson(errorBody, SimpleErrorDto::class.java)
    } catch (e: Exception) {
        e.printStackTrace()
        SimpleErrorDto(detail = Constants.DEFAULT_ERROR)
    }
    return errorResponse?.detail
        ?: Constants.DEFAULT_ERROR
}

private fun HttpException.handleServerErrors(): String {
    val errorBody = this.response()?.errorBody()?.string()
    val gson = Gson()
    val errorResponse = try {
        gson.fromJson(errorBody, ErrorDto::class.java)
    } catch (e: Exception) {
        e.printStackTrace()
        ErrorDto(listOf(ErrorDetail(msg = Constants.DEFAULT_ERROR)))
    }
    return errorResponse?.errorDetails?.get(0)?.msg
        ?: Constants.DEFAULT_ERROR
}
