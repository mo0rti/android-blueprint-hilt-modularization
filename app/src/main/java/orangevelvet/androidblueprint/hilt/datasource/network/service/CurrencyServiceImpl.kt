package orangevelvet.androidblueprint.hilt.datasource.network.service

import orangevelvet.androidblueprint.hilt.domain.contract.CurrencyService
import orangevelvet.androidblueprint.hilt.domain.model.Currency

class CurrencyServiceImpl: CurrencyService {
    override fun getCurrencies(): List<Currency> {
        return emptyList()
    }
}