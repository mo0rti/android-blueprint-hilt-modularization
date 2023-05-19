package mortitech.blueprint.core.manager.contract

import mortitech.blueprint.core.domain.model.ApplicationState

interface ApplicationStateManager {
    fun loadState(): ApplicationState
    fun saveState(applicationState: ApplicationState): Boolean
}