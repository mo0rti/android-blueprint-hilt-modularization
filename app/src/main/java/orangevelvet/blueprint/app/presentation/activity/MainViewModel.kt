package orangevelvet.blueprint.app.presentation.activity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import orangevelvet.blueprint.account.domain.contract.EventNetworkService
import orangevelvet.blueprint.account.domain.model.Event
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val eventNetworkService: EventNetworkService
): ViewModel() {

    suspend fun load(): List<Event> {
        return eventNetworkService.getLatestEvents()
    }
}