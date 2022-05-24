package kr.hs.dgsw.domain.model

data class MyAllApply(
    val idx: Int,
    val state: Int,
    val postIdx: Int,
    val userIdx: Int,
    val title: String,
    val personnel: Int,
    val currentPersonnel: Int,
    val postState: Int,
)