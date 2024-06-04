package adl.appture.uistates.domain.usecases

import adl.appture.uistates.ui.states.UiState
import kotlinx.coroutines.flow.Flow

fun interface FetchPlaceHolderUseCase {
    fun fetchInformation(): Flow<UiState<Unit>>
}
