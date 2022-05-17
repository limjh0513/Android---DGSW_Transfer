package kr.hs.dgsw.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.model.Apply
import kr.hs.dgsw.domain.model.MyApply
import kr.hs.dgsw.domain.request.ApplyRequest

interface ApplyRepository {
    fun getApply(idx: Int): Single<List<Apply>>
    fun getMyApply(idx: Int): Single<List<Apply>>
    fun getPostMyApply(postIdx: Int, userIdx: Int): Single<MyApply>
    fun postApply(request: ApplyRequest): Single<Boolean>
    fun putApply(applyIdx: Int, state: Int): Single<Int>
}