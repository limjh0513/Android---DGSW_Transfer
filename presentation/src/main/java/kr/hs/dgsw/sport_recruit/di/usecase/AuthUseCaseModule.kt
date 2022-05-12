package kr.hs.dgsw.sport_recruit.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import kr.hs.dgsw.domain.usecase.auth.RegisterUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AuthUseCaseModule {
    @Singleton
    @Provides
    fun provideLoginUseCase(repository: AuthRepository): LoginUseCase =
        LoginUseCase(repository)

    @Singleton
    @Provides
    fun provideRegisterUseCase(repository: AuthRepository): RegisterUseCase =
        RegisterUseCase(repository)
}