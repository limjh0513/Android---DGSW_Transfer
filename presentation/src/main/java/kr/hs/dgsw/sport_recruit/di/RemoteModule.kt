package kr.hs.dgsw.sport_recruit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.network.remote.ApplyRemote
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.data.network.remote.PostRemote
import kr.hs.dgsw.data.network.remote.UserRemote
import kr.hs.dgsw.data.network.service.ApplyService
import kr.hs.dgsw.data.network.service.AuthService
import kr.hs.dgsw.data.network.service.PostService
import kr.hs.dgsw.data.network.service.UserService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Singleton
    @Provides
    fun provideApplyRemote(applyService: ApplyService): ApplyRemote =
        ApplyRemote(applyService)

    @Singleton
    @Provides
    fun provideAuthRemote(authService: AuthService): AuthRemote =
        AuthRemote(authService)

    @Singleton
    @Provides
    fun providePostRemote(postService: PostService): PostRemote =
        PostRemote(postService)

    @Singleton
    @Provides
    fun provideUserRemote(userService: UserService): UserRemote =
        UserRemote(userService)
}