package bluevelvet.blueprint.core.contract.session

import bluevelvet.blueprint.core.model.ApplicationState

interface ApplicationStateManager {
    fun loadState(): ApplicationState
    fun saveState(applicationState: ApplicationState): Boolean
}