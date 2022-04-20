package kr.hs.dgsw.domain.usecase.apply

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.ApplyRepository
import kr.hs.dgsw.domain.request.ApplyRequest
import javax.inject.Inject

class PostApplyUseCase @Inject constructor(private val repository: ApplyRepository) :
    ParamsUseCase<PostApplyUseCase.Params, Single<Boolean>>() {

    override fun buildUseCaseObservable(params: Params): Single<Boolean> =
        repository.postApply(params.request)

    data class Params(
        val request: ApplyRequest,
    )
}