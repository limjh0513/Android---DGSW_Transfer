package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.LoginRequest
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository) : ParamsUseCase<LoginUseCase.Params, Single<Int>>() {
    override fun buildUseCaseObservable(params: Params): Single<Int> =
        repository.login(params.request)

    data class Params(
        val request: LoginRequest,
    )

}