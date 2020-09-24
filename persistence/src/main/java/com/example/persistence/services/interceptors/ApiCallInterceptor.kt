package com.example.persistence.services.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class ApiCallInterceptor @Inject constructor(val apiKey: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? = chain?.run {
        val url = request().url().newBuilder().addQueryParameter("api_key", apiKey).build()
        proceed(request().newBuilder().url(url).build())
    }

}