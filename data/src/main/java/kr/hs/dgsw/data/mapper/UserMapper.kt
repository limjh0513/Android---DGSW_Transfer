package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.network.response.UserResponse
import kr.hs.dgsw.domain.model.User

fun UserResponse.toEntity(): User {
    return User(
        this.grade,
        this.room,
        this.number,
        this.name,
        this.profileImage
    )
}

fun User.toResponse(): UserResponse {
    return UserResponse(
        this.grade,
        this.room,
        this.number,
        this.name,
        this.profileImage
    )
}