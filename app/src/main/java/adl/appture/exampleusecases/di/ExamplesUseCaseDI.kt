package adl.appture.exampleusecases.di

import org.koin.dsl.module

object ExamplesUseCaseDI {

    val module = module {
        ExamplesUseCaseInject.get(this)
    }
}