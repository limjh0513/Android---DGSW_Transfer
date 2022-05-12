package kr.hs.dgsw.sport_recruit.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.domain.repository.ApplyRepository
import kr.hs.dgsw.domain.usecase.apply.GetApplyUseCase
import kr.hs.dgsw.domain.usecase.apply.GetMyApplyUseCase
import kr.hs.dgsw.domain.usecase.apply.GetPostMyApplyUseCase
import kr.hs.dgsw.domain.usecase.apply.PostApplyUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplyUseCase {
    @Singleton
    @Provides
    fun provideGetApplyUseCase(repository: ApplyRepository) : GetApplyUseCase =
        GetApplyUseCase(repository)

    @Singleton
    @Provides
    fun provideGetMyApplyUseCase(repository: ApplyRepository): GetMyApplyUseCase =
        GetMyApplyUseCase(repository)


    @Singleton
    @Provides
    fun provideGetPostMyApplyUseCase(repository: ApplyRepository): GetMyApplyUseCase =
        GetMyApplyUseCase(repository)

    @Singleton
    @Provides
    fun providePostApplyUseCase(repository: ApplyRepository): PostApplyUseCase =
        PostApplyUseCase(repository)
}