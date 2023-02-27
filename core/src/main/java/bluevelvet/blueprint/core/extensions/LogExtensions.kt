package bluevelvet.blueprint.core.extensions

import android.util.Log

const val LOG_TAG = "Hilt-Modularisation"

fun Log.debug(log: String) {
    Log.d(LOG_TAG, log)
}

fun Log.error(error: String) {
    Log.e(LOG_TAG, error)
}