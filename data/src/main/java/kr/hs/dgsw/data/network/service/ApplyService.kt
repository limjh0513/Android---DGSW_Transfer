package kr.hs.dgsw.data.network.service

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.network.response.ApplyResponse
import kr.hs.dgsw.data.network.response.BaseResponse
import kr.hs.dgsw.data.network.response.MyAllApplyResponse
import kr.hs.dgsw.data.network.response.MyApplyResponse
import kr.hs.dgsw.domain.request.ApplyRequest
import retrofit2.Response
import retrofit2.http.*

interface ApplyService {
    @GET("apply/get/{idx}")
    fun getApply(@Path("idx") idx: Int): Single<Response<BaseResponse<List<ApplyResponse>>>>

    @GET("apply/get/my/{userIdx}")
    fun getMyApply(@Path("userIdx") idx: Int): Single<Response<BaseResponse<List<MyAllApplyResponse>>>>

    @GET("apply/get/{postIdx}/{userIdx}")
    fun getPostMyApply(
        @Path("postIdx") postIdx: Int,
        @Path("userIdx") userIdx: Int,
    ): Single<Response<BaseResponse<MyApplyResponse>>>

    @POST("apply/post")
    fun postApply(@Body request: ApplyRequest): Single<Response<BaseResponse<Boolean>>>

    @PUT("apply/put/{applyIdx}/{state}")
    fun putApply(
        @Path("applyIdx") applyIdx: Int,
        @Path("state") state: Int,
    ): Single<Response<BaseResponse<Int>>>
}