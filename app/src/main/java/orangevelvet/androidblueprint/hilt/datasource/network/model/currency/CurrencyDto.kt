package orangevelvet.androidblueprint.hilt.datasource.network.model.currency

import com.google.gson.annotations.SerializedName
import orangevelvet.androidblueprint.hilt.datasource.network.model.base.BaseNetworkModel
import orangevelvet.androidblueprint.hilt.domain.model.Currency

data class CurrencyDto (
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("min_size")
    val minSize: Double
): BaseNetworkModel() {
    fun convertToDomainModel() = Currency(
        id, name, minSize
    )
}