package kr.hs.dgsw.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest

interface AuthRepository {
    fun login(request: LoginRequest): Single<Int>
    fun register(request: RegisterRequest): Single<Int>
}