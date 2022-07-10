package orangevelvet.androidblueprint.hilt.domain.manager

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import orangevelvet.androidblueprint.hilt.domain.contract.session.ApplicationStateManager
import orangevelvet.androidblueprint.hilt.domain.model.ApplicationState
import javax.inject.Inject

class ApplicationStateManagerImpl
@Inject
constructor(
    context: Context,
    private val gson: Gson
): ApplicationStateManager {

    private companion object {
        const val FILE_NAME = "bluePrintHilt"
    }

    private var _sharedPref: SharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    override fun loadState(): ApplicationState {
        return _sharedPref.getString("appState", "").let {
            gson.fromJson(it, ApplicationState::class.java)
        } ?: kotlin.run {
            ApplicationState("")
        }
    }

    override fun saveState(applicationState: ApplicationState): Boolean {
        _sharedPref.edit()?.apply {
            putString(gson.toJson(applicationState), "")
            commit()
        }
        return true
    }
}
