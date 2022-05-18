package kr.hs.dgsw.sport_recruit.di.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.domain.repository.PostRepository
import kr.hs.dgsw.domain.usecase.post.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PostUseCaseModule {

    @Singleton
    @Provides
    fun provideGetAllPostUseCase(repository: PostRepository): GetAllPostUseCase =
        GetAllPostUseCase(repository)

    @Singleton
    @Provides
    fun provideGetCategoryPostUseCase(repository: PostRepository): GetCategoryPostUseCase =
        GetCategoryPostUseCase(repository)

    @Singleton
    @Provides
    fun provideGetDetailPostUseCase(repository: PostRepository): GetDetailPostUseCase =
        GetDetailPostUseCase(repository)

    @Singleton
    @Provides
    fun provideGetMyPostUseCase(repository: PostRepository): GetMyPostUseCase =
        GetMyPostUseCase(repository)

    @Singleton
    @Provides
    fun provideGetStatePostUseCase(repository: PostRepository): GetStatePostUseCase =
        GetStatePostUseCase(repository)

    @Singleton
    @Provides
    fun provideWritePostUseCase(repository: PostRepository): WritePostUseCase =
        WritePostUseCase(repository)

    @Singleton
    @Provides
    fun providePutPostEndedUseCase(repository: PostRepository): PutPostEndedUseCase =
        PutPostEndedUseCase(repository)
}