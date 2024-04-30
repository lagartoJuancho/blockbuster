package com.jda.blockbuster.data.remote

import com.jda.blockbuster.data.utils.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest
            .newBuilder()
            .url(
                chain.request().url
                    .newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .build()
            )
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}