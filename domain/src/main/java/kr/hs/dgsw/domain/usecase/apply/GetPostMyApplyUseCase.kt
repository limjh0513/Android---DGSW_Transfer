package kr.hs.dgsw.domain.usecase.apply

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.MyApply
import kr.hs.dgsw.domain.repository.ApplyRepository
import javax.inject.Inject


class GetPostMyApplyUseCase @Inject constructor(private val repository: ApplyRepository) :
    ParamsUseCase<GetPostMyApplyUseCase.Params, Single<MyApply>>() {
    override fun buildUseCaseObservable(params: Params): Single<MyApply> =
        repository.getPostMyApply(params.postIdx, params.userIdx)


    data class Params(
        val postIdx: Int,
        val userIdx: Int,
    )

}