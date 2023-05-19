package mortitech.blueprint.core.extensions

import java.util.*
import kotlin.random.Random


/**
 * Extension functions for [String]
 **/

fun String.randomId(): String {
    return UUID.randomUUID().toString()
}

fun String.randomText(
    length: Int = 10,
    hasDigits: Boolean = false
): String {
    val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + (' ') +
            if (hasDigits) ('0'..'9') else emptyList()

    return (1..length)
        .map {
            Random.nextInt(0, charPool.size).let { charPool[it] }
        }.joinToString("")
}

fun String.randomWords(
    length: Int = 10
): String {
    val wordPool = listOf(
        "steward", "brother", "sister", "man", "woman", "goose", "surface",
        "boom", "rumor", "mastermind", "splurge", "flash", "picture",
        "parallel", "needle", "mobile", "television", "differ", "trace",
    )

    return (1..length).joinToString(" ") {
        Random.nextInt(0, wordPool.size).let { wordPool[it] }
    }
}