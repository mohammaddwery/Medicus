package com.medicus.app.data.data_resource.remote_resource.api

data class ErrorResponse(
    val message: String?=null,
    val statusCode: String?=null,
    val error: String?=null
)