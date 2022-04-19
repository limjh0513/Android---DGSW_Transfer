package kr.hs.dgsw.domain.model

import java.sql.Timestamp

data class Post(
    val idx: Int,
    val title: String,
    val content: String,
    val personal: Int,
    val currentPersonal: Int,
    val writter: String,
    val writterImage: String,
    val time: Timestamp,
    val state: Int,
    val category: Int,
)
