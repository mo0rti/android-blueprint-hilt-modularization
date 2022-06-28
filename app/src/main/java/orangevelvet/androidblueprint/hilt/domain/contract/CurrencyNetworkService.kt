package orangevelvet.androidblueprint.hilt.domain.contract

import orangevelvet.androidblueprint.hilt.domain.model.Currency

interface CurrencyNetworkService {
    suspend fun getCurrencies(): List<Currency>
}
