package kr.hs.dgsw.data.datasource

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.mapper.toEntity
import kr.hs.dgsw.data.network.remote.PostRemote
import kr.hs.dgsw.domain.model.DetailPost
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.domain.request.WriteRequest
import javax.inject.Inject

class PostDataSource @Inject constructor(override val remote: PostRemote) :
    BaseDataSource<PostRemote>() {
    fun writePost(request: WriteRequest): Single<Boolean> =
        remote.writePost(request)

    fun getAllPost(): Single<List<Post>> =
        remote.getAllPost().map { responses ->
            val postList = ArrayList<Post>()

            responses.forEach {
                postList.add(it.toEntity())
            }

            postList
        }

    fun getCategoryPost(category: Int): Single<List<Post>> =
        remote.getCategoryPost(category).map { responses ->
            val postList = ArrayList<Post>()

            responses.forEach {
                postList.add(it.toEntity())
            }

            postList
        }

    fun getStatePost(state: Int): Single<List<Post>> =
        remote.getStatePost(state).map { responses ->
            val postList = ArrayList<Post>()

            responses.forEach {
                postList.add(it.toEntity())
            }

            postList
        }

    fun getDetailPost(postIdx: Int): Single<DetailPost> =
        remote.getDetailPost(postIdx).map { it.toEntity() }

    fun getMyPost(userIdx: Int): Single<List<Post>> =
        remote.getMyPost(userIdx).map { responses ->
            val postList = ArrayList<Post>()

            responses.forEach {
                postList.add(it.toEntity())
            }

            postList

        }

    fun putPostEnded(postIdx: Int): Single<Boolean> =
        remote.putPostEnded(postIdx)
}