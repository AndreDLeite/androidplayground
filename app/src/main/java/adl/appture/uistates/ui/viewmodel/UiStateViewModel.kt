package adl.appture.uistates.ui.viewmodel

import adl.appture.uistates.domain.usecases.FetchPlaceHolderUseCase
import adl.appture.uistates.ui.states.UiState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UiStateViewModel(
    private val fetchPlaceHolderUseCase: FetchPlaceHolderUseCase
): ViewModel() {

    private val _informationState = MutableLiveData<UiState<Unit>>()
    val informationState: LiveData<UiState<Unit>> = _informationState

    fun fetchInformation() {
        viewModelScope.launch {
            fetchPlaceHolderUseCase.fetchInformation().collect { useCaseInformation ->
                _informationState.postValue(useCaseInformation)
            }
        }
    }

}
