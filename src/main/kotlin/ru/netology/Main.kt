package ru.netology

fun main() {
    val seconds = 5000
    val status = agoToText(seconds)
    println(status)
}

fun agoToText (seconds: Int): String {
    val time: Int
    val results: String = when (seconds) {
        in 0..60 -> "был(а) только что"
        in 61..60*60 -> {
            time = seconds / 60
            "был(а) $time ${minutesEnds(seconds)} назад"
        }
        in 60*60+1..24*60*60 -> {
            time = seconds / 60 / 60
            "был(а) в сети $time ${hoursEnds(seconds)} назад"
        }
        in (24+1)*60*60..(24+24)*60*60 -> "был(а) сегодня"
        in (24+24+1)*60*60..(24+24+24)*60*60 -> "был(а) вчера"
        else -> "был(а) давно"
    }
    return results
}

fun minutesEnds (seconds: Int): String {
    val minutes = seconds / 60
    val results: String = if (minutes in 5..20) {
        "минут"
    } else if (minutes.toString().endsWith("1")) {
        "минуту"
    } else if (minutes % 10 == 2 || minutes % 10 == 3 || minutes % 10 == 4) {
        "минуты"
    } else {
        "минут"
    }
    return results
}

fun hoursEnds (seconds: Int): String {
    val hours = seconds / 60 / 60
    val results: String = when (hours) {
        in 5..20 -> "часов"
        1, 21 -> "час"
        else -> "часа"
    }
    return results
}