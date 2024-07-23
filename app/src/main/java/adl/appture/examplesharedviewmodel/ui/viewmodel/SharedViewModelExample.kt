package adl.appture.examplesharedviewmodel.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SharedViewModelExample: ViewModel() {

    private val _stateFlowCount = MutableStateFlow(0)
    val stateFlowCount = _stateFlowCount.asStateFlow()

    fun addValue() {
        viewModelScope.launch {
            _stateFlowCount.value++
        }
    }

    fun subtractValue() {
        viewModelScope.launch {
            _stateFlowCount.value--
        }
    }

}
