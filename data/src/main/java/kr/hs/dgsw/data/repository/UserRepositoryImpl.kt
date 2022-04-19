package kr.hs.dgsw.data.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.datasource.UserDataSource
import kr.hs.dgsw.domain.model.User
import kr.hs.dgsw.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val dataSource: UserDataSource): UserRepository {
    override fun inquireUser(id: Int): Single<User> =
        dataSource.inquireUser(id)
}