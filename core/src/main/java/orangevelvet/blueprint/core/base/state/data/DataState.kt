package orangevelvet.blueprint.core.base.state.data

data class DataState<T>(
    var error: StateError? = null,
    var loading: Boolean = false,
    var data: Data<T>? = null
) {

    companion object {

        fun <T> error(
            response: Response,
            errorType: StateErrorType = StateErrorType.General
        ): DataState<T> {
            return DataState(
                error =
                    StateError(
                        response,
                        errorType
                ),
                loading = false,
                data = null
            )
        }

        fun <T> error(message: String) = error<T>(Response(message))

        fun <T> loading(): DataState<T> {
            return DataState(
                error = null,
                loading = true,
            )
        }

        fun <T> data(
            data: T? = null,
            response: Response = Response()
        ): DataState<T> {
            return DataState(
                error = null,
                loading = false,
                data = Data(
                    data,
                    response
                )
            )
        }
    }
}