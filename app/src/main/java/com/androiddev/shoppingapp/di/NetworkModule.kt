package com.androiddev.shoppingapp.di

import android.app.Application
import coil.ImageLoader
import coil.memory.MemoryCache
import com.androiddev.shoppingapp.BuildConfig
import com.androiddev.shoppingapp.R
import com.androiddev.shoppingapp.util.Constant
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

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

    @Provides
    @Singleton
    fun provideImageLoader(app: Application): ImageLoader {
        return ImageLoader.Builder(app)
            .memoryCache { MemoryCache.Builder(app).maxSizePercent(0.5).build() }
            .crossfade(true)
            .crossfade(2000)
            .placeholder(R.drawable.discount)
            .error(R.drawable.discount)
            .build()
    }
}

