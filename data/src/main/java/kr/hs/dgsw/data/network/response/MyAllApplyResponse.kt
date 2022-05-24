package kr.hs.dgsw.data.network.response

data class MyAllApplyResponse(
    val idx: Int,
    val state: Int,
    val postIdx: Int,
    val userIdx: Int,
    val title: String,
    val personnel: Int,
    val currentPersonnel: Int,
    val postState: Int,
)
