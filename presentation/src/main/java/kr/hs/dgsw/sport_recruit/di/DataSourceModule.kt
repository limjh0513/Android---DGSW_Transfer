package kr.hs.dgsw.sport_recruit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.datasource.ApplyDataSource
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.data.datasource.PostDataSource
import kr.hs.dgsw.data.datasource.UserDataSource
import kr.hs.dgsw.data.network.remote.ApplyRemote
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.data.network.remote.PostRemote
import kr.hs.dgsw.data.network.remote.UserRemote
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Singleton
    @Provides
    fun provideApplyDataSource(applyRemote: ApplyRemote): ApplyDataSource =
        ApplyDataSource(applyRemote)

    @Singleton
    @Provides
    fun provideAuthDataSource(authRemote: AuthRemote): AuthDataSource =
        AuthDataSource(authRemote)

    @Singleton
    @Provides
    fun providePostDataSource(postRemote: PostRemote): PostDataSource =
        PostDataSource(postRemote)

    @Singleton
    @Provides
    fun providesUserDataSource(userRemote: UserRemote): UserDataSource =
        UserDataSource(userRemote)
}