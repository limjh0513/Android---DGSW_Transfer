package kr.hs.dgsw.domain.usecase.post

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.DetailPost
import kr.hs.dgsw.domain.repository.PostRepository
import javax.inject.Inject

class GetDetailPostUseCase @Inject constructor(private val repository: PostRepository) :
    ParamsUseCase<GetDetailPostUseCase.Params, Single<DetailPost>>() {

    override fun buildUseCaseObservable(params: Params): Single<DetailPost> =
        repository.getDetailPost(params.postIdx)

    data class Params(
        val postIdx: Int,
    )

}