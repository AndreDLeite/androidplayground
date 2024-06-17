package adl.appture.uistates.di

import adl.appture.shared.factory.HTTPClient
import adl.appture.shared.providers.UrlProviders
import adl.appture.uistates.data.remote.api.service.UiStateService
import adl.appture.uistates.data.remote.networking.UiStateServiceImpl
import adl.appture.uistates.data.repository.UiStateRepositoryImpl
import adl.appture.uistates.domain.repository.UiStateRepository
import adl.appture.uistates.domain.usecases.FetchPlaceHolderUseCase
import adl.appture.uistates.domain.usecases.FetchPlaceHolderUseCaseImpl
import adl.appture.uistates.ui.viewmodel.UiStateViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named

object UiStateInjects {

    fun get(module: Module) = with(module) {
        getViewModels(this)
        getServices(this)
        getRepositories(this)
        getUseCases(this)
    }

    private fun getServices(module: Module) = with(module) {
        single<UiStateService>(named("UiStateService")) {
            UiStateServiceImpl(
                HTTPClient.create(
                    UrlProviders.BASE_DUMMY_URL,
                    UiStateService::class
                )
            )
        }
    }

    private fun getRepositories(module: Module) = with(module) {
        factory<UiStateRepository> { UiStateRepositoryImpl(get()) }
    }

    private fun getViewModels(module: Module) = with(module) {
        viewModel { UiStateViewModel(get()) }
    }

    private fun getUseCases(module: Module) = with(module) {
        factory<FetchPlaceHolderUseCase> { FetchPlaceHolderUseCaseImpl(get(), Dispatchers.IO) }
    }
}