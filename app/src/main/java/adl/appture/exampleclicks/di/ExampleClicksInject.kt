package adl.appture.exampleclicks.di

import adl.appture.exampleclicks.ui.viewmodel.ClicksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module

object ExampleClicksInject {
    fun get(module: Module) = with(module) {
        getViewModels(this)
    }

    private fun getViewModels(module: Module) = with(module) {
        viewModel { ClicksViewModel() }
    }
}