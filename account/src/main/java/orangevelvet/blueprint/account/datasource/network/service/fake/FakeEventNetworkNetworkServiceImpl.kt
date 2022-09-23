package orangevelvet.blueprint.account.datasource.network.service.fake

import kotlinx.coroutines.delay
import orangevelvet.blueprint.account.domain.contract.EventNetworkService
import orangevelvet.blueprint.account.domain.model.Event
import java.util.*
import javax.inject.Inject

class FakeEventNetworkNetworkServiceImpl
@Inject
constructor(): EventNetworkService {
    override suspend fun getLatestEvents(): List<Event> {
        delay(500)
        return listOf(
            Event(UUID.randomUUID().toString(), "Title 1", "Description 1", "", "https://via.placeholder.com/400x200")
        )
    }

    override suspend fun bookmarkEvent(event: Event): Boolean {
        delay(500)
        return true
    }
}
