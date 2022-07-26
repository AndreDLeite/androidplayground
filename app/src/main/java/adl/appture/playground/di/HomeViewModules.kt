package adl.appture.playground.di

import adl.appture.playground.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class HomeViewModules {
    operator fun invoke(): Module = module {
        viewModel { HomeViewModel() }
    }
}