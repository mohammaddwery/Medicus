package com.medicus.app.data.data_resource.remote_resource.api

data class ErrorResponse(
    val code: String,
    val message: String?=null,
    val status: String?=null
)