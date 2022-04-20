package kr.hs.dgsw.domain.usecase.apply

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.Apply
import kr.hs.dgsw.domain.repository.ApplyRepository
import javax.inject.Inject

class GetApplyUseCase @Inject constructor(private val repository: ApplyRepository): ParamsUseCase<GetApplyUseCase.Params, Single<List<Apply>>>() {

    override fun buildUseCaseObservable(params: Params): Single<List<Apply>> =
        repository.getApply(params.idx)

    data class Params(
        val idx: Int
    )
}