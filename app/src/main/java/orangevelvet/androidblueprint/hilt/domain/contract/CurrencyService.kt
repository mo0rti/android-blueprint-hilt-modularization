package orangevelvet.androidblueprint.hilt.domain.contract

import orangevelvet.androidblueprint.hilt.domain.model.Currency

interface CurrencyService {
    fun getCurrencies(): List<Currency>
}
