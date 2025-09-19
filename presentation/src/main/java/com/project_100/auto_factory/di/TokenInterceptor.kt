package com.project_100.auto_factory.di

import android.content.Context
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class TokenInterceptor @Inject constructor(
    @ApplicationContext val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        return chain.proceed(setToken(chain))
    }

    private fun setToken(chain: Interceptor.Chain): Request {
        val builder = chain.request().newBuilder()
        builder.addHeader("User-Agent", "touse")

        getCookieValue()?.let {
            builder.apply {
                addHeader("Cookie", it)
            }
        }
        return builder.build()
    }


    private fun getCookieValue(): String? {
        return "PrefManager.getCookieInfo()"
    }
}