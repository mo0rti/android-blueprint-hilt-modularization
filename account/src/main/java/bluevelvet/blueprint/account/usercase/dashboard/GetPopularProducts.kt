package bluevelvet.blueprint.account.usercase.dashboard

import bluevelvet.blueprint.account.data.local.contract.DashboardLocalService
import bluevelvet.blueprint.account.data.remote.contract.DashboardRemoteService
import bluevelvet.blueprint.core.domain.model.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPopularProducts(
    private val localService: DashboardLocalService,
    private val remoteService: DashboardRemoteService,
) {
    suspend operator fun invoke(): Flow<List<Product>> = flow {
        emit(remoteService.getPopularProducts())
    }
}