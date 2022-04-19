package kr.hs.dgsw.data.network.remote

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.response.UserResponse
import kr.hs.dgsw.data.network.service.UserService
import javax.inject.Inject

class UserRemote @Inject constructor(override val service: UserService):BaseRemote<UserService>() {
    fun inquireUser(id: Int): Single<UserResponse> =
        service.inquireUser(id).map(getResponseData())
}