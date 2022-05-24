package kr.hs.dgsw.data.datasource

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.mapper.toEntity
import kr.hs.dgsw.data.network.remote.ApplyRemote
import kr.hs.dgsw.domain.model.Apply
import kr.hs.dgsw.domain.model.MyAllApply
import kr.hs.dgsw.domain.model.MyApply
import kr.hs.dgsw.domain.request.ApplyRequest
import javax.inject.Inject

class ApplyDataSource @Inject constructor(override val remote: ApplyRemote) :
    BaseDataSource<ApplyRemote>() {
    fun getApply(idx: Int): Single<List<Apply>> =
        remote.getApply(idx).map { responses ->
            val applyList = ArrayList<Apply>()

            responses.forEach {
                applyList.add(it.toEntity())
            }

            applyList
        }

    fun getPostMyApply(postIdx: Int, userIdx: Int): Single<MyApply> =
        remote.getPostMyApply(postIdx, userIdx).map { it.toEntity() }

    fun getMyApply(idx: Int): Single<List<MyAllApply>> =
        remote.getMyApply(idx).map { responses ->
            val applyList = ArrayList<MyAllApply>()

            responses.forEach {
                applyList.add(it.toEntity())
            }

            applyList
        }

    fun postApply(request: ApplyRequest): Single<Boolean> =
        remote.postApply(request)

    fun putApply(applyIdx: Int, state: Int): Single<Int> =
        remote.putApply(applyIdx, state)
}