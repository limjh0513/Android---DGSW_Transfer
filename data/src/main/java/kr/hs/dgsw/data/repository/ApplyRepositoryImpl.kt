package kr.hs.dgsw.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.datasource.ApplyDataSource
import kr.hs.dgsw.domain.model.Apply
import kr.hs.dgsw.domain.repository.ApplyRepository
import kr.hs.dgsw.domain.request.ApplyRequest
import javax.inject.Inject

class ApplyRepositoryImpl @Inject constructor(private val dataSource: ApplyDataSource) :
    ApplyRepository {
    override fun getApply(idx: Int): Single<List<Apply>> =
        dataSource.getApply(idx)

    override fun getMyApply(idx: Int): Single<List<Apply>> =
        dataSource.getMyApply(idx)

    override fun getPostMyApply(postIdx: Int, userIdx: Int): Single<Int> =
        dataSource.getPostMyApply(postIdx, userIdx)


    override fun postApply(request: ApplyRequest): Single<Boolean> =
        dataSource.postApply(request)
}