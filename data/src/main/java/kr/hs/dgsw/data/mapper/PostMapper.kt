package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.network.response.AllPostResponse
import kr.hs.dgsw.domain.model.Post

fun AllPostResponse.toEntity(): Post {
    return Post(
        this.idx,
        this.title,
        this.content,
        this.personal,
        this.currentPersonal,
        this.writter,
        this.writterImage,
        this.time,
        this.state,
        this.category
    )
}

fun Post.toResponse(): AllPostResponse{
    return AllPostResponse(
        this.idx,
        this.title,
        this.content,
        this.personal,
        this.currentPersonal,
        this.writter,
        this.writterImage,
        this.time,
        this.state,
        this.category
    )
}