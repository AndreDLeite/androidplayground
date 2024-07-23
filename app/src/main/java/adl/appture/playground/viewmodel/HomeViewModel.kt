package adl.appture.playground.viewmodel

import adl.appture.playground.domain.model.HomeCardEnum
import adl.appture.playground.domain.model.HomeCardModel
import android.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

class HomeViewModel : ViewModel() {

    fun teste() = runBlocking {
        val totalTime = measureTimeMillis {
            val delay1 = async { delayFunction1() }
            val delay2 = async { delayFunction2() }
            val result1 = delay1.await()
            val result2 = delay2.await()
            println("TotalTime: ${result1 + result2} ms")
        }
        println("Done")
    }

    suspend fun delayFunction1(): Long {
        val delayTime = 1000L
        delay(delayTime)
        return delayTime
    }

    suspend fun delayFunction2(): Long {
        val delayTime = 500L
        delay(delayTime)
        return delayTime
    }

    private val _homeCards = MutableStateFlow<List<HomeCardModel>>(listOf())
    val homeCards = _homeCards.asStateFlow()

    init {
        generateHomeCards()
    }

    private fun generateHomeCards() {
        viewModelScope.launch {
            _homeCards.value =
                listOf(
                    HomeCardModel(
                        cardName = "Camera",
                        cardColor = Color.parseColor("#32c7b8"),
                        cardType = HomeCardEnum.CAMERA
                    ),
                    HomeCardModel(
                        cardName = "Componentes",
                        cardColor = Color.parseColor("#218a7f"),
                        cardType = HomeCardEnum.COMPONENTS
                    ),
                    HomeCardModel(
                        cardName = "Firebase",
                        cardColor = Color.parseColor("#79af56"),
                        cardType = HomeCardEnum.FIREBASE
                    ),
                    HomeCardModel(
                        cardName = "Clicks Example",
                        cardColor = Color.parseColor("#d1c252"),
                        cardType = HomeCardEnum.CLICKS
                    ),
                    HomeCardModel(
                        cardName = "Add view skeleton example",
                        cardColor = Color.parseColor("#f59740"),
                        cardType = HomeCardEnum.VIEWS
                    ),
                )
        }
    }

}