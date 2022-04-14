package kr.hs.dgsw.data.network.response

data class UserResponse(
    val grade: Int,
    val room: Int,
    val number: Int,
    val name: String,
    val profileImage: String,
)