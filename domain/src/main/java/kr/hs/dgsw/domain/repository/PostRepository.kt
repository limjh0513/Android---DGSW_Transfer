package kr.hs.dgsw.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.model.DetailPost
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.domain.request.WriteRequest

interface PostRepository {
    fun writePost(request: WriteRequest): Single<Boolean>
    fun getAllPost(): Single<List<Post>>
    fun getCategoryPost(category: Int): Single<List<Post>>
    fun getStatePost(state: Int): Single<List<Post>>
    fun getDetailPost(postIdx: Int): Single<DetailPost>
    fun getMyPost(userIdx: Int): Single<List<Post>>
}