package mortitech.blueprint.core.ui.state.data

data class Data<T>(val data: T?, val response: Response?)

data class StateError(val response: Response, var type: StateErrorType = StateErrorType.General)
enum class StateErrorType {
    General,
    InCorrectPinCode
}

data class Response(
    val message: String? = "",
    val responseType: ResponseType = ResponseType.None
)

sealed class ResponseType{
    object Toast: ResponseType()
    object Dialog: ResponseType()
    object Balloon: ResponseType()
    object None: ResponseType()
}
