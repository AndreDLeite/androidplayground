package adl.appture.playground.core

import adl.appture.exampleclicks.di.ExampleClicksDI
import adl.appture.exampleusecases.di.ExamplesUseCaseDI
import adl.appture.playground.di.HomeViewModules
import adl.appture.uistates.di.UiStateDI
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class PlaygroundApp: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoinInjections()
    }

    private fun setupKoinInjections() {
        startKoin {
            androidContext(this@PlaygroundApp)
            androidFileProperties()

            modules(
                HomeViewModules().invoke(),
                ExamplesUseCaseDI.module,
                ExampleClicksDI.module,
                UiStateDI.module,
            )
        }
    }

}