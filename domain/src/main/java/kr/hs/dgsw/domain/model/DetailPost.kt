package kr.hs.dgsw.domain.model

import android.os.Parcelable
import java.io.Serializable
import java.sql.Timestamp

data class DetailPost(
    val idx: Int,
    val title: String,
    val content: String,
    val personal: Int,
    val currentPersonal: Int,
    val place: String,
    val writter: String,
    val writterImage: String,
    val time: Timestamp,
    val state: Int,
    val category: Int,
    val hidden: Int
): Serializable
