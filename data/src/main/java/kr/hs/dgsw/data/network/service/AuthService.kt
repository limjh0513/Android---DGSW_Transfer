package kr.hs.dgsw.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.network.response.BaseResponse
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.request.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    fun login(@Body loginRequest: LoginRequest): Single<Response<BaseResponse<Int>>>

    @POST("auth/register")
    fun register(@Body registerRequest: RegisterRequest): Single<Response<BaseResponse<Int>>>
}