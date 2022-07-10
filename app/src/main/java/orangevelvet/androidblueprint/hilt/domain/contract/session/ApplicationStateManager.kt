package orangevelvet.androidblueprint.hilt.domain.contract.session

import orangevelvet.androidblueprint.hilt.domain.model.ApplicationState

interface ApplicationStateManager {
    fun loadState(): ApplicationState
    fun saveState(applicationState: ApplicationState): Boolean
}