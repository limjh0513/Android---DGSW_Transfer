package kr.hs.dgsw.data.datasource

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import javax.inject.Inject

class AuthDataSource @Inject constructor(override val remote: AuthRemote) :
    BaseDataSource<AuthRemote>() {
    fun login(request: LoginRequest): Single<Int> =
        remote.login(request)

    fun register(request: RegisterRequest): Single<Int> =
        remote.register(request)
}