package kr.hs.dgsw.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.network.response.AllPostResponse
import kr.hs.dgsw.data.network.response.BaseResponse
import kr.hs.dgsw.data.network.response.DetailPostResponse
import kr.hs.dgsw.domain.request.WriteRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostService {
    @POST("post/write")
    fun writePost(@Body writeRequest: WriteRequest): Single<Response<BaseResponse<Boolean>>>

    @GET("post/all")
    fun getAllPost(): Single<Response<BaseResponse<List<AllPostResponse>>>>

    @GET("post/category/{category}")
    fun getCategoryPost(@Path("category") category: Int): Single<Response<BaseResponse<List<AllPostResponse>>>>

    @GET("post/state/{state}")
    fun getStatePost(@Path("state") state: Int): Single<Response<BaseResponse<AllPostResponse>>>

    @GET("post/detail/{postIdx}")
    fun getDetailPost(@Path("postIdx") postIdx: Int): Single<Response<BaseResponse<DetailPostResponse>>>

    @GET("post/my/{userIdx}")
    fun getMyPost(@Path("userIdx") userIdx: Int): Single<Response<BaseResponse<List<AllPostResponse>>>>
}