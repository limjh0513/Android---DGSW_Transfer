package kr.hs.dgsw.sport_recruit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.datasource.ApplyDataSource
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.data.datasource.PostDataSource
import kr.hs.dgsw.data.datasource.UserDataSource
import kr.hs.dgsw.data.repository.ApplyRepositoryImpl
import kr.hs.dgsw.data.repository.AuthRepositoryImpl
import kr.hs.dgsw.data.repository.PostRepositoryImpl
import kr.hs.dgsw.data.repository.UserRepositoryImpl
import kr.hs.dgsw.domain.repository.ApplyRepository
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.repository.PostRepository
import kr.hs.dgsw.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideApplyRepository(applyDataSource: ApplyDataSource): ApplyRepository =
        ApplyRepositoryImpl(applyDataSource)

    @Singleton
    @Provides
    fun provideAuthRepository(authDataSource: AuthDataSource): AuthRepository =
        AuthRepositoryImpl(authDataSource)

    @Singleton
    @Provides
    fun providePostRepository(postDataSource: PostDataSource): PostRepository =
        PostRepositoryImpl(postDataSource)

    @Singleton
    @Provides
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository =
        UserRepositoryImpl(userDataSource)
}