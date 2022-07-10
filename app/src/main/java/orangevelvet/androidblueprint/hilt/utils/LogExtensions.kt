package orangevelvet.androidblueprint.hilt.utils

import android.util.Log

const val LOG_TAG = "BluePrintHilt"

fun Log.debug(log: String) {
    Log.d(LOG_TAG, log)
}

fun Log.error(error: String) {
    Log.e(LOG_TAG, error)
}