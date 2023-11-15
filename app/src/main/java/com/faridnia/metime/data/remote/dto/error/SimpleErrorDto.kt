package com.faridnia.metime.data.remote.dto.error


import com.google.gson.annotations.SerializedName

data class SimpleErrorDto(
    @SerializedName("detail")
    val detail: String? = null
)