package adl.appture.examplesharedviewmodel.di

import adl.appture.examplesharedviewmodel.ui.viewmodel.SharedViewModelExample
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module

object SharedViewModelInject {
    fun get(module: Module) = with(module) {
        getViewModels(this)
    }

    private fun getViewModels(module: Module) = with(module) {
        viewModel { SharedViewModelExample() }
    }
}