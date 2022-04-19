package kr.hs.dgsw.domain.model

import java.sql.Timestamp

data class Apply(
    val idx: Int,
    val grade: Int,
    val room: Int,
    val number: Int,
    val name: String,
    val time: Timestamp,
    val state: Int,
    val postIdx: Int,
    val userIdx: Int,
)
