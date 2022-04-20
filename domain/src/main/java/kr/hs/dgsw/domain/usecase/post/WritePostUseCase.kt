package kr.hs.dgsw.domain.usecase.post

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.PostRepository
import kr.hs.dgsw.domain.request.WriteRequest
import javax.inject.Inject

class WritePostUseCase @Inject constructor(private val repository: PostRepository) :
    ParamsUseCase<WritePostUseCase.Params, Single<Boolean>>() {

    override fun buildUseCaseObservable(params: Params): Single<Boolean> =
        repository.writePost(params.request)

    data class Params(
        val request: WriteRequest,
    )
}