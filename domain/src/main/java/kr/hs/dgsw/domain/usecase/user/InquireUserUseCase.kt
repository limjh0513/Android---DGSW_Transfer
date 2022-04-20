package kr.hs.dgsw.domain.usecase.user

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.User
import kr.hs.dgsw.domain.repository.UserRepository
import javax.inject.Inject

class InquireUserUseCase @Inject constructor(private val repository: UserRepository) :
    ParamsUseCase<InquireUserUseCase.Params, Single<User>>() {

    override fun buildUseCaseObservable(params: Params): Single<User> =
        repository.inquireUser(params.id)

    data class Params(
        val id: Int,
    )
}