package com.project_100.auto_factory.di

import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.teddy_park.data.service.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val loggingInterceptor = HttpLoggingInterceptor()

//    private fun loggingInterceptor(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//    }

    class AddHeaderInterceptor: Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()

            request.newBuilder().addHeader("User-Agent", "touse").build()

            val isMultiPart = request.headers.names().contains("multipart")
            loggingInterceptor.level = if (isMultiPart) HttpLoggingInterceptor.Level.NONE else HttpLoggingInterceptor.Level.BODY

            return chain.proceed(request)

        }
    }

    class ReceivedHeaderInterceptor: Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val originalResponse = chain.proceed(chain.request())
            val headers = originalResponse.headers
            return originalResponse
        }
    }



    @Provides
    @Singleton
    fun provideOkHttpClient(tokenInterceptor: TokenInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1000, TimeUnit.SECONDS)
            .readTimeout(1000, TimeUnit.SECONDS)
            .writeTimeout(1000, TimeUnit.SECONDS)
            .addInterceptor(tokenInterceptor)
            .addInterceptor(AddHeaderInterceptor())
            .addInterceptor(ReceivedHeaderInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    @Named("Retrofit")
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://121.171.82.20:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(@Named("Retrofit") retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}