package kr.hs.dgsw.domain.request

data class RegisterRequest(
    val id: String,
    val password: String,
    val grade: Int,
    val room: Int,
    val number: Int,
    val name: String,
    val profileImage: String,
)
