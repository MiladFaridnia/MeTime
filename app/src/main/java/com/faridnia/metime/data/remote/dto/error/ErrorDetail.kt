package com.faridnia.metime.data.remote.dto.error


import com.google.gson.annotations.SerializedName

data class ErrorDetail(
    @SerializedName("loc")
    val loc: List<String>? = null,
    @SerializedName("msg")
    val msg: String? = null,
    @SerializedName("type")
    val type: String? = null
)