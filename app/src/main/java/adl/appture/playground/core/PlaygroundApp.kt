package adl.appture.playground.core

import adl.appture.playground.di.HomeViewModules
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
                HomeViewModules().invoke()
            )
        }
    }

}