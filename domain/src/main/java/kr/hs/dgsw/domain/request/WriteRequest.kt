package kr.hs.dgsw.domain.request

import java.sql.Timestamp

data class WriteRequest(
    val title: String,
    val content: String,
    val personnel: Int,
    val place: String,
    val writter: Int,
    val time: String,
    val category: Int,
    val state: Int,
    val anonymous: Int,
    val hidden: Int,
)
