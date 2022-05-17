package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.network.response.MyApplyResponse
import kr.hs.dgsw.domain.model.MyApply

fun MyApplyResponse.toEntity(): MyApply {
    return MyApply(
        this.idx,
        this.state
    )
}

fun MyApply.toResponse(): MyApplyResponse {
    return MyApplyResponse(
        this.idx,
        this.state
    )
}