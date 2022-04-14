package kr.hs.dgsw.domain.request

data class ApplyRequest(
    val grade: Int,
    val room: Int,
    val number: Int,
    val name: String,
    val postIdx: Int,
    val userIdx: Int,
)
