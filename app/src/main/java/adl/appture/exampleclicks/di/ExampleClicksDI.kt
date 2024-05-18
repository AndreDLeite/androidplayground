package adl.appture.exampleclicks.di

import org.koin.dsl.module

object ExampleClicksDI {

    val module = module {
        ExampleClicksInject.get(this)
    }
}