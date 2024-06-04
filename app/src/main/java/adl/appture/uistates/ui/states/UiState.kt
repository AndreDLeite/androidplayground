package adl.appture.uistates.ui.states

sealed class UiState<out T> where T : Any? {
    object Loading : UiState<Nothing>()

    data class Success<T>(val data: T) :UiState<T>()

    data class Failure(val errorMessage: String?) : UiState<Nothing>()
}

