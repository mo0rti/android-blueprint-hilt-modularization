package bluevelvet.blueprint.account.usercase.dashboard

import bluevelvet.blueprint.account.data.local.contract.DashboardLocalService
import bluevelvet.blueprint.account.data.remote.contract.DashboardRemoteService
import bluevelvet.blueprint.core.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class GetPopularProducts(
    private val localService: DashboardLocalService,
    private val remoteService: DashboardRemoteService,
) {
    suspend operator fun invoke(): Flow<List<Product>> = flow {
        /* TODO: Products should be cached into local service first
        // First emit the cache records
        emit(localService.getProducts())

        // Get the result from remote api
        val remoteResult = remoteService.getCategories()

        // Thread-safe write to latestNews
        mutex.withLock {
            localService.insertOrUpdateCategories(remoteResult)

            // Emit written values from cache
            emit(localService.getCategories())
        }
        */

        emit(remoteService.getPopularProducts())
    }
}