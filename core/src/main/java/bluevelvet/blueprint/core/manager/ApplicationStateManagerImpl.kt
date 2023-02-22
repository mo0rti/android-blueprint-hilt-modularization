package bluevelvet.blueprint.core.manager

import android.content.Context
import android.content.SharedPreferences
import bluevelvet.blueprint.core.contract.session.ApplicationStateManager
import bluevelvet.blueprint.core.model.ApplicationState
import com.google.gson.Gson
import javax.inject.Inject

class ApplicationStateManagerImpl
@Inject
constructor(
    context: Context,
    private val gson: Gson
): ApplicationStateManager {

    private companion object {
        const val FILE_NAME = "bluevelvet.blueprint"
    }

    // For security reasons, it's better to use EncryptedSharedPreferences
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
            apply()
        }
        return true
    }
}
