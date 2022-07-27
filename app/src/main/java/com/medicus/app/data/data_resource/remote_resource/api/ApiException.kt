package com.medicus.app.data.data_resource.remote_resource.api

import java.io.IOException

data class ApiException(
    val error: ErrorResponse
) : IOException("${error.message?:""} ${error.status?:""}")
