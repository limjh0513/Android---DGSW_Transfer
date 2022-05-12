package kr.hs.dgsw.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.network.response.ApplyResponse
import kr.hs.dgsw.data.network.response.BaseResponse
import kr.hs.dgsw.domain.request.ApplyRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApplyService {
    @GET("apply/get/{idx}")
    fun getApply(@Path("idx") idx: Int): Single<Response<BaseResponse<List<ApplyResponse>>>>

    @GET("apply/get/my/{userIdx}")
    fun getMyApply(@Path("userIdx") idx: Int): Single<Response<BaseResponse<List<ApplyResponse>>>>

    @GET("apply/get/{postIdx}/{userIdx}")
    fun getPostMyApply(@Path("postIdx") postIdx:Int, @Path("userIdx") userIdx:Int):Single<Response<BaseResponse<Int>>>

    @POST("apply/post")
    fun postApply(@Body request: ApplyRequest): Single<Response<BaseResponse<Boolean>>>
}