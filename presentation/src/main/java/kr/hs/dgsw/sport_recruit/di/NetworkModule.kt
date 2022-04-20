package kr.hs.dgsw.sport_recruit.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.util.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()

    @Singleton
    @Provides
    fun provideCallAdapterFactory(): CallAdapter.Factory =
        RxJava3CallAdapterFactory.create() as CallAdapter.Factory

    @Singleton
    @Provides
    fun provideConverterFactory(): Converter.Factory =
        GsonConverterFactory.create() as Converter.Factory

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, callAdapter: CallAdapter.Factory, converter: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constant.SERVER_HOST)
            .addCallAdapterFactory(callAdapter)
            .addConverterFactory(converter)
            .client(okHttpClient)
            .build()

}