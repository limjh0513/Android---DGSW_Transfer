package kr.hs.dgsw.domain.usecase.apply

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.ApplyRepository
import javax.inject.Inject

class PutApplyUseCase @Inject constructor(private val repository: ApplyRepository) :
    ParamsUseCase<PutApplyUseCase.Params, Single<Int>>() {

    override fun buildUseCaseObservable(params: Params): Single<Int> =
        repository.putApply(params.applyIdx, params.state)

    data class Params(
        val applyIdx: Int,
        val state: Int,
    )
}