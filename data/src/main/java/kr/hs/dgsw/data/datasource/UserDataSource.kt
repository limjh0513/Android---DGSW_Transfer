package kr.hs.dgsw.data.datasource

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.mapper.toEntity
import kr.hs.dgsw.data.network.remote.UserRemote
import kr.hs.dgsw.domain.model.User
import javax.inject.Inject

class UserDataSource @Inject constructor(override val remote: UserRemote) :
    BaseDataSource<UserRemote>() {
    fun inquireUser(id: Int): Single<User> =
        remote.inquireUser(id).map { it.toEntity() }
}