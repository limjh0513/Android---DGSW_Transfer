package kr.hs.dgsw.data.network.remote

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.response.AllPostResponse
import kr.hs.dgsw.data.network.response.DetailPostResponse
import kr.hs.dgsw.data.network.service.PostService
import kr.hs.dgsw.domain.request.WriteRequest
import javax.inject.Inject

class PostRemote @Inject constructor(override val service: PostService) :
    BaseRemote<PostService>() {
    fun writePost(request: WriteRequest): Single<Boolean> =
        service.writePost(request).map(getResponseData())

    fun getAllPost(): Single<List<AllPostResponse>> =
        service.getAllPost().map(getResponseData())

    fun getCategoryPost(category: Int): Single<List<AllPostResponse>> =
        service.getCategoryPost(category).map(getResponseData())

    fun getStatePost(state: Int): Single<List<AllPostResponse>> =
        service.getStatePost(state).map(getResponseData())

    fun getDetailPost(postIdx: Int): Single<DetailPostResponse> =
        service.getDetailPost(postIdx).map(getResponseData())

    fun getMyPost(userIdx: Int): Single<List<AllPostResponse>> =
        service.getMyPost(userIdx).map(getResponseData())
}