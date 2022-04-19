package kr.hs.dgsw.data.datasource

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.mapper.toEntity
import kr.hs.dgsw.data.network.remote.ApplyRemote
import kr.hs.dgsw.domain.model.Apply
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

    fun getMyApply(idx: Int): Single<List<Apply>> =
        remote.getMyApply(idx).map { responses ->
            val applyList = ArrayList<Apply>()

            responses.forEach {
                applyList.add(it.toEntity())
            }

            applyList
        }

    fun postApply(request: ApplyRequest): Single<Boolean> =
        remote.postApply(request)
}