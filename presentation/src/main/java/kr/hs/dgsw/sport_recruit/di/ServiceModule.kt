package kr.hs.dgsw.sport_recruit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.network.service.ApplyService
import kr.hs.dgsw.data.network.service.AuthService
import kr.hs.dgsw.data.network.service.PostService
import kr.hs.dgsw.data.network.service.UserService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Singleton
    @Provides
    fun provideApplyService(retrofit: Retrofit): ApplyService =
        retrofit.create(ApplyService::class.java)

    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)

    @Singleton
    @Provides
    fun providePostService(retrofit: Retrofit): PostService =
        retrofit.create(PostService::class.java)

    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)
}