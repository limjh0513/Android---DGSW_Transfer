package kr.hs.dgsw.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.network.response.BaseResponse
import kr.hs.dgsw.data.network.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("user/inquire/{id}")
    fun inquireUser(@Path("id") id: Int): Single<Response<BaseResponse<UserResponse>>>
}