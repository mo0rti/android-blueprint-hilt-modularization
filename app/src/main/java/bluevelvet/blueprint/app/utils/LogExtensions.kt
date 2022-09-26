package bluevelvet.blueprint.app.utils

import android.util.Log

const val LOG_TAG = "HiltModularisation"

fun Log.debug(log: String) {
    Log.d(LOG_TAG, log)
}

fun Log.error(error: String) {
    Log.e(LOG_TAG, error)
}