package kr.hs.dgsw.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.model.User

interface UserRepository {
    fun inquireUser(id: Int): Single<User>
}