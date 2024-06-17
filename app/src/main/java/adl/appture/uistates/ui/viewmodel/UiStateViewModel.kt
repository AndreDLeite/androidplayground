package adl.appture.uistates.ui.viewmodel

import adl.appture.uistates.domain.usecases.FetchPlaceHolderUseCase
import adl.appture.uistates.ui.states.UiState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UiStateViewModel(
    private val fetchPlaceHolderUseCase: FetchPlaceHolderUseCase
): ViewModel() {

    private val _stateFlowResponse = MutableStateFlow<UiState<Unit>>(UiState.Loading)
    val stateFlowResponse = _stateFlowResponse.asStateFlow()

    private val _sharedStateFlow = MutableSharedFlow<UiState<Unit>>()
    val sharedStateFlow = _sharedStateFlow.asSharedFlow()

    fun fetchInformation() {
        viewModelScope.launch {
            fetchPlaceHolderUseCase.fetchInformation().collect { useCaseInformation ->
                _stateFlowResponse.value = useCaseInformation
                _sharedStateFlow.emit(useCaseInformation)
            }
        }
    }

}
