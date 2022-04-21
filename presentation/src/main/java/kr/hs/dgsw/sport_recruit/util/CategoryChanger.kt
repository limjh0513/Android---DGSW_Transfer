package kr.hs.dgsw.sport_recruit.util

fun categoryToInt(category: String): Int {
    return when (category) {
        "축구" -> 0
        "배드민턴" -> 1
        "농구" -> 2
        else -> 3
    }
}

fun categoryToString(category: Int): String {
    return when (category) {
        0 -> "축구"
        1 -> "배드민턴"
        2 -> "농구"
        else -> "기타"
    }
}