package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.network.response.ApplyResponse
import kr.hs.dgsw.domain.model.Apply

fun ApplyResponse.toEntity(): Apply {
    return Apply(
        this.idx,
        this.grade,
        this.room,
        this.number,
        this.name,
        this.time,
        this.state,
        this.postIdx,
        this.userIdx
    )
}

fun Apply.toResponse(): ApplyResponse {
    return ApplyResponse(
        this.idx,
        this.grade,
        this.room,
        this.number,
        this.name,
        this.time,
        this.state,
        this.postIdx,
        this.userIdx
    )
}