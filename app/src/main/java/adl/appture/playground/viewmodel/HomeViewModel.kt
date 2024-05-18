package adl.appture.playground.viewmodel

import adl.appture.playground.domain.model.HomeCardEnum
import adl.appture.playground.domain.model.HomeCardModel
import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val _homeCards = MutableLiveData<List<HomeCardModel>>()
    val homeCards: LiveData<List<HomeCardModel>> = _homeCards

    init {
        generateHomeCards()
    }

    private fun generateHomeCards() {
        viewModelScope.launch {
            _homeCards.postValue(
                listOf(
                    HomeCardModel(cardName = "Camera",cardColor = Color.parseColor("#32c7b8"), cardType = HomeCardEnum.CAMERA),
                    HomeCardModel(cardName = "Componentes",cardColor = Color.parseColor("#218a7f"), cardType = HomeCardEnum.COMPONENTS),
                    HomeCardModel(cardName = "Firebase",cardColor = Color.parseColor("#79af56"), cardType = HomeCardEnum.FIREBASE),
                    HomeCardModel(cardName = "Clicks Example",cardColor = Color.parseColor("#d1c252"), cardType = HomeCardEnum.CLICKS),
                )
            )
        }
    }

}