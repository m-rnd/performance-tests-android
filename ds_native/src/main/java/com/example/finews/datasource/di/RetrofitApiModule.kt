package com.example.finews.datasource.di


import androidx.core.os.trace
import com.example.entity.common.TraceSection
import com.example.finews.datasource.BuildConfig
import com.example.finews.datasource.api.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RetrofitApiModule {

    private const val BASE_URL = "http://10.102.17.45:3001/"

    @Provides
    fun provideGson(): GsonConverterFactory = trace(TraceSection.RETROFIT_INIT_GSON.traceName) {
        GsonConverterFactory.create()
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        trace(TraceSection.RETROFIT_INIT_LOGGING.traceName) {
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        }

    @Provides
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        trace(TraceSection.RETROFIT_INIT_HTTP_CLIENT.traceName) {
            OkHttpClient.Builder().apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(loggingInterceptor)
                }
            }.build()
        }

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        httpClient: OkHttpClient,
    ): Retrofit = trace(TraceSection.RETROFIT_INIT_RETRO_BUILDER.traceName) {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(httpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsService(
        retrofit: Retrofit,
    ): NewsService = trace(TraceSection.RETROFIT_INIT_SERVICE.traceName) {
        retrofit.create(
            NewsService::class.java
        )
    }
}