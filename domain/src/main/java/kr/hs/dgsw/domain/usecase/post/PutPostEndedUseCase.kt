package kr.hs.dgsw.domain.usecase.post

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.PostRepository
import javax.inject.Inject

class PutPostEndedUseCase @Inject constructor(private val repository: PostRepository) :
    ParamsUseCase<PutPostEndedUseCase.Params, Single<Boolean>>() {
    override fun buildUseCaseObservable(params: Params): Single<Boolean> =
        repository.putPostEnded(params.postIdx)

    data class Params(
        val postIdx: Int,
    )

}