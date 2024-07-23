package adl.appture.examplesharedviewmodel.di

import org.koin.dsl.module

object SharedViewModelDI {

    val module = module {
        SharedViewModelInject.get(this)
    }
}