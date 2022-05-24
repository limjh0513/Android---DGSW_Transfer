package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.network.response.MyAllApplyResponse
import kr.hs.dgsw.domain.model.MyAllApply

fun MyAllApplyResponse.toEntity(): MyAllApply {
    return MyAllApply(
        this.idx,
        this.state,
        this.postIdx,
        this.userIdx,
        this.title,
        this.personnel,
        this.currentPersonnel,
        this.postState,
    )
}

fun MyAllApply.toResponse(): MyAllApplyResponse {
    return MyAllApplyResponse(
        this.idx,
        this.state,
        this.postIdx,
        this.userIdx,
        this.title,
        this.personnel,
        this.currentPersonnel,
        this.postState,
    )
}