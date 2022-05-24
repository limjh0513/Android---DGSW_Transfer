package kr.hs.dgsw.domain.usecase.apply

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.Apply
import kr.hs.dgsw.domain.model.MyAllApply
import kr.hs.dgsw.domain.repository.ApplyRepository
import javax.inject.Inject

class GetMyApplyUseCase @Inject constructor(private val repository: ApplyRepository) :
    ParamsUseCase<GetMyApplyUseCase.Params, Single<List<MyAllApply>>>() {

    override fun buildUseCaseObservable(params: Params): Single<List<MyAllApply>> =
        repository.getMyApply(params.idx)

    data class Params(
        val idx: Int,
    )
}