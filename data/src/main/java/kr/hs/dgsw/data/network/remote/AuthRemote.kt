package kr.hs.dgsw.data.network.remote

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.AuthService
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import javax.inject.Inject

class AuthRemote @Inject constructor(override val service: AuthService) :
    BaseRemote<AuthService>() {
    fun login(request: LoginRequest): Single<Int> =
        service.login(request).map(getResponseData())

    fun register(request: RegisterRequest): Single<Int> =
        service.register(request).map(getResponseData())
}