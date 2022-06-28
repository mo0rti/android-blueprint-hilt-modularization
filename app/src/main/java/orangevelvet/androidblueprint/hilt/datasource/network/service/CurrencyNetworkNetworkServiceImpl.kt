package orangevelvet.androidblueprint.hilt.datasource.network.service

import orangevelvet.androidblueprint.hilt.datasource.network.api.CurrencyApi
import orangevelvet.androidblueprint.hilt.domain.contract.CurrencyNetworkService
import orangevelvet.androidblueprint.hilt.domain.model.Currency
import javax.inject.Inject

class CurrencyNetworkNetworkServiceImpl
@Inject
constructor(
    private val api: CurrencyApi
): CurrencyNetworkService {
    override suspend fun getCurrencies(): List<Currency> {
        return api.getCurrencies().data.map { it.convertToDomainModel() }
    }
}
