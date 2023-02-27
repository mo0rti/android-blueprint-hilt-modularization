package bluevelvet.blueprint.account.usercase.dashboard

import bluevelvet.blueprint.account.data.local.contract.DashboardLocalService
import bluevelvet.blueprint.account.data.remote.contract.DashboardRemoteService
import bluevelvet.blueprint.core.domain.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class GetCategories(
    private val localService: DashboardLocalService,
    private val remoteService: DashboardRemoteService,
) {
    // Mutex to make writes to cached values thread-safe.
    private val mutex = Mutex()

    suspend operator fun invoke() : Flow<List<Category>> = flow {
        // First emit the cache records
        emit(localService.getCategories())

        // Get the result from remote api
        val remoteResult = remoteService.getCategories()

        // Thread-safe write to latestNews
        mutex.withLock {
            localService.insertOrUpdateCategories(remoteResult)

            // Emit written values from cache
            emit(localService.getCategories())
        }
    }
}