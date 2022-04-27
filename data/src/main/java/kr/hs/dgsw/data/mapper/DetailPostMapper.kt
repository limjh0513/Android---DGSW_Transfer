package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.network.response.DetailPostResponse
import kr.hs.dgsw.domain.model.DetailPost

fun DetailPostResponse.toEntity(): DetailPost {
    return DetailPost(
        this.idx,
        this.title,
        this.content,
        this.personal,
        this.currentPersonal,
        this.place,
        this.writter,
        this.writterImage,
        this.time,
        this.state,
        this.category,
        this.hidden
    )
}

fun DetailPost.toResponse(): DetailPostResponse {
    return DetailPostResponse(
        this.idx,
        this.title,
        this.content,
        this.personal,
        this.currentPersonal,
        this.place,
        this.writter,
        this.writterImage,
        this.time,
        this.state,
        this.category,
        this.hidden)
}