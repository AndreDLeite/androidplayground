package adl.appture.uistates.di

import org.koin.dsl.module

object UiStateDI {

    val module = module {
        UiStateInjects.get(this)
    }

}
