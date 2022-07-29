package com.medicus.app.data.data_resource.remote_resource.api

import java.io.IOException

class NoConnectionException : IOException() {
    override val message: String
        get() = "No Internet Connection"
}