package kr.hs.dgsw.sport_recruit.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.domain.repository.UserRepository
import kr.hs.dgsw.domain.usecase.user.InquireUserUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserUseCase {

    @Singleton
    @Provides
    fun provideInquireUserUseCase(repository: UserRepository): InquireUserUseCase =
        InquireUserUseCase(repository)
}