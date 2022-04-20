package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.RegisterRequest
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository: AuthRepository) :
    ParamsUseCase<RegisterUseCase.Params, Single<Int>>() {

    override fun buildUseCaseObservable(params: Params): Single<Int> =
        repository.register(params.request)

    data class Params(
        val request: RegisterRequest,
    )
}