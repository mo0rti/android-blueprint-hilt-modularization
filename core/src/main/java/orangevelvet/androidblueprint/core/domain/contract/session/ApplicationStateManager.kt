package orangevelvet.androidblueprint.core.domain.contract.session

import orangevelvet.androidblueprint.core.domain.model.ApplicationState

interface ApplicationStateManager {
    fun loadState(): ApplicationState
    fun saveState(applicationState: ApplicationState): Boolean
}