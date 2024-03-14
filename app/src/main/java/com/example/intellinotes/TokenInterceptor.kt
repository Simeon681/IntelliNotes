package com.example.intellinotes

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor(
    private val sharedPreferences: SharedPreferencesInstance
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val isLoginOrRegistrationRequest =
            isLoginOrRegistrationRequest(originalRequest.url.toString())

        val token: String? = if (!isLoginOrRegistrationRequest) {
            sharedPreferences.getJwtToken()
        } else {
            null
        }

        val newRequest: Request = originalRequest.newBuilder()
            .apply {
                token?.let { header("Authorization", "Bearer $it") }
            }
            .build()

        return chain.proceed(newRequest)
    }

    private fun isLoginOrRegistrationRequest(requestUrl: String): Boolean {
        return requestUrl.contains("/mobile-backend-api/v1/auth/signup")
                || requestUrl.contains("/mobile-backend-api/v1/auth/signin")
    }
}