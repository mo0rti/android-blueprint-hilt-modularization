package bluevelvet.blueprint.core.extensions

import kotlin.math.pow
import kotlin.math.roundToLong
import kotlin.random.Random

/**
 * Extension functions for all the numeric types.
 **/

fun Double.roundTo(numberOfDecimals: Int = 1): Double {
    val factor = 10.0.pow(numberOfDecimals)
    return (this * factor).roundToLong() / factor
}

fun Double.randomNumber(
    from: Double = 1.0,
    until: Double = 5.0,
    numberOfDecimals: Int = 1,
) = Random.nextDouble(from, until).roundTo(numberOfDecimals)
