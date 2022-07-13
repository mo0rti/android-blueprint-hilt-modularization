package orangevelvet.blueprint.core.domain.contract.session

import orangevelvet.blueprint.core.domain.model.ApplicationState

interface ApplicationStateManager {
    fun loadState(): ApplicationState
    fun saveState(applicationState: ApplicationState): Boolean
}