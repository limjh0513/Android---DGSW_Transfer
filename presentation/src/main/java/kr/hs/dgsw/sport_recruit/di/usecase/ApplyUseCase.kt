package kr.hs.dgsw.sport_recruit.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.domain.repository.ApplyRepository
import kr.hs.dgsw.domain.usecase.apply.*
import kr.hs.dgsw.domain.usecase.post.GetMyPostUseCase
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
    fun provideGetPostMyApplyUseCase(repository: ApplyRepository): GetPostMyApplyUseCase =
        GetPostMyApplyUseCase(repository)

    @Singleton
    @Provides
    fun providePostApplyUseCase(repository: ApplyRepository): PostApplyUseCase =
        PostApplyUseCase(repository)

    @Singleton
    @Provides
    fun providePutApplyUseCase(repository: ApplyRepository): PutApplyUseCase =
        PutApplyUseCase(repository)
}