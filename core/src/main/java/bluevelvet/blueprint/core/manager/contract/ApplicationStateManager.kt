package bluevelvet.blueprint.core.manager.contract

import bluevelvet.blueprint.core.domain.model.ApplicationState

interface ApplicationStateManager {
    fun loadState(): ApplicationState
    fun saveState(applicationState: ApplicationState): Boolean
}