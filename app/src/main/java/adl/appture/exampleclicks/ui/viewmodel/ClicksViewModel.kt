package adl.appture.exampleclicks.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ClicksViewModel: ViewModel() {

    private val _singleClickCounter = MutableLiveData<Int>()
    val singleClickCounter: LiveData<Int> = _singleClickCounter

    private val _multipleClickCounter = MutableLiveData<Int>()
    val multipleClickCounter: LiveData<Int> = _multipleClickCounter

    private val _canNavigate = LiveEvent<Boolean>()
    val canNavigate: LiveData<Boolean> = _canNavigate

    private var _singleClicksCounter = 0
    private var _multipleClicksCounter = 0

    fun addToSingleClicks() {
        viewModelScope.launch {
            _singleClicksCounter++
            _singleClickCounter.postValue(_singleClicksCounter)
        }
    }

    fun addToMultipleClicks() {
        viewModelScope.launch {
            _multipleClicksCounter++
            _multipleClickCounter.postValue(_multipleClicksCounter)
        }
    }

    fun handleNavigationClick() {
        viewModelScope.launch {
            delay(1000)
            _canNavigate.postValue(true)
        }
    }

}
