package kr.hs.dgsw.data.network.response

import java.sql.Timestamp

data class ApplyResponse(
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