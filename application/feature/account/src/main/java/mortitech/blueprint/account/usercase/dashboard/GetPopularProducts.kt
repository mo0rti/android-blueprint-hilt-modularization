package mortitech.blueprint.account.usercase.dashboard

import mortitech.blueprint.account.data.local.contract.DashboardLocalService
import mortitech.blueprint.account.data.remote.contract.DashboardRemoteService
import mortitech.blueprint.core.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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