package adl.appture.exampleusecases.di

import adl.appture.exampleusecases.data.api.networking.UserDataSource
import adl.appture.exampleusecases.data.api.networking.UserDataSourceImpl
import adl.appture.exampleusecases.data.repository.UserRepositoryImpl
import adl.appture.exampleusecases.domain.repository.UserRepository
import adl.appture.exampleusecases.domain.usecases.FetchUserProfileImageUseCase
import adl.appture.exampleusecases.domain.usecases.FetchUserProfileImageUseCaseImpl
import adl.appture.exampleusecases.ui.viewmodels.UserProfileViewModel
import adl.appture.exampleusecases.ui.viewmodels.UserSettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module

object ExamplesUseCaseInject {
    fun get(module: Module) = with(module) {
        getDataSources(this)
        getRepositories(this)
        getUseCases(this)
        getViewModels(this)
    }

    private fun getDataSources(module: Module) = with(module) {
        factory<UserDataSource> { UserDataSourceImpl() }
    }

    private fun getRepositories(module: Module) = with(module) {
        factory<UserRepository> { UserRepositoryImpl(get()) }
    }

    private fun getUseCases(module: Module) = with(module) {
        factory<FetchUserProfileImageUseCase> { FetchUserProfileImageUseCaseImpl(get()) }
    }

    private fun getViewModels(module: Module) = with(module) {
        viewModel { UserSettingViewModel(get()) }
        viewModel { UserProfileViewModel(get()) }
    }

}