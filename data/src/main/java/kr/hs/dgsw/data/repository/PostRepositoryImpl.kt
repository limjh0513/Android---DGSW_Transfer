package kr.hs.dgsw.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.datasource.PostDataSource
import kr.hs.dgsw.domain.model.DetailPost
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.domain.repository.PostRepository
import kr.hs.dgsw.domain.request.WriteRequest
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val dataSource: PostDataSource): PostRepository {
    override fun writePost(request: WriteRequest): Single<Boolean> =
        dataSource.writePost(request)

    override fun getAllPost(): Single<List<Post>> =
        dataSource.getAllPost()

    override fun getCategoryPost(category: Int): Single<List<Post>> =
        dataSource.getCategoryPost(category)

    override fun getStatePost(state: Int): Single<List<Post>> =
        dataSource.getStatePost(state)

    override fun getDetailPost(postIdx: Int): Single<DetailPost> =
        dataSource.getDetailPost(postIdx)

    override fun getMyPost(userIdx: Int): Single<List<Post>> =
        dataSource.getMyPost(userIdx)
}