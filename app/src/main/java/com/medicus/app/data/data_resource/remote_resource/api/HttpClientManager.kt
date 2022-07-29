package com.medicus.app.data.data_resource.remote_resource.api

import android.content.Context
import com.google.gson.Gson
import com.medicus.app.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HttpClientManager {
    fun provide(context: Context, baseUrl: String): Retrofit {
        val client = OkHttpClient.Builder()
            .handleErrors()
            .setNetworkInterceptor(context = context)
            .setLogger(HttpLoggingInterceptor.Level.BODY)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(client)
            .setConverters()
            .baseUrl(baseUrl)
            .build()
    }

    private fun Retrofit.Builder.setConverters() =
        addConverterFactory(GsonConverterFactory.create())

    private fun OkHttpClient.Builder.setLogger(
        logLevel: HttpLoggingInterceptor.Level
    ): OkHttpClient.Builder {
        if (BuildConfig.DEBUG) {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = logLevel
            })
        }
        return this
    }

    private fun OkHttpClient.Builder.setNetworkInterceptor(context: Context) : OkHttpClient.Builder =
        addInterceptor(NetworkConnectionInterceptor(context))

    private fun OkHttpClient.Builder.handleErrors() = addInterceptor { chain ->
        val response = chain.proceed(chain.request())

        if (response.isSuccessful) {
            response
        } else {
            val code = response.code
            val body = response.body

            if(body == null) throw ApiException(ErrorResponse(statusCode = code.toString(), message= "Something went wrong"))

            throw try {
                val gson = Gson()
                val errorResponse: ErrorResponse = gson.fromJson(response.body!!.charStream(), ErrorResponse::class.java)
                ApiException(errorResponse)
            } catch (ex: Exception) {
                ApiException(ErrorResponse(statusCode=code.toString(), message="Something went wrong"))
            } finally {
                body.close()
            }
        }
    }
}