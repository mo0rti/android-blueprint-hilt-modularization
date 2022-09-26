package bluevelvet.blueprint.core.domain.contract.session

import bluevelvet.blueprint.core.domain.model.ApplicationState

interface ApplicationStateManager {
    fun loadState(): ApplicationState
    fun saveState(applicationState: ApplicationState): Boolean
}