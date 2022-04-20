package kr.hs.dgsw.domain.usecase.post

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.domain.repository.PostRepository
import javax.inject.Inject

class GetMyPostUseCase @Inject constructor(private val repository: PostRepository) :
    ParamsUseCase<GetMyPostUseCase.Params, Single<List<Post>>>() {

    override fun buildUseCaseObservable(params: Params): Single<List<Post>> =
        repository.getMyPost(params.userIdx)

    data class Params(
        val userIdx: Int,
    )
}