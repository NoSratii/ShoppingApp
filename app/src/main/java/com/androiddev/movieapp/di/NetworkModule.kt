package com.androiddev.movieapp.di

import com.androiddev.movieapp.BuildConfig
import com.androiddev.movieapp.util.Constant
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    var clientInterceptor = Interceptor { chain ->
        var request: Request = chain.request()
        val url: HttpUrl = request.url.newBuilder().addQueryParameter("apikey", "value").build()
        request = request.newBuilder().url(url).build()
        chain.proceed(request)
    }

    @Provides
    fun provideMoshiBuilder(): Moshi.Builder = Moshi.Builder()

    @Provides
    fun provideMoshi(builder: Moshi.Builder): Moshi = builder.build()


    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient()
        val builder = okHttpClient.newBuilder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) builder.addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        return builder.build()
    }


    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient ,moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }


}