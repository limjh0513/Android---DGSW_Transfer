package kr.hs.dgsw.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val dataSource: AuthDataSource): AuthRepository {
    override fun login(request: LoginRequest): Single<Int> =
        dataSource.login(request)

    override fun register(request: RegisterRequest): Single<Int> =
        dataSource.register(request)
}