package com.faridnia.metime.data.remote.dto.error


import com.google.gson.annotations.SerializedName

data class ErrorDto(
    @SerializedName("detail")
    val errorDetails: List<ErrorDetail?>? = null
)