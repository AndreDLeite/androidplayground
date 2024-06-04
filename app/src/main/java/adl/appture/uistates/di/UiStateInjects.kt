package adl.appture.uistates.di

import adl.appture.shared.factory.HTTPClient
import adl.appture.shared.providers.UrlProviders.UI_STATE_BASE_URL
import adl.appture.uistates.data.api.service.UiStateService
import adl.appture.uistates.data.repository.UiStateRepositoryImpl
import adl.appture.uistates.domain.repository.UiStateRepository
import adl.appture.uistates.domain.usecases.FetchPlaceHolderUseCase
import adl.appture.uistates.domain.usecases.FetchPlaceHolderUseCaseImpl
import adl.appture.uistates.ui.viewmodel.UiStateViewModel
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import java.util.concurrent.TimeUnit

object UiStateInjects {

    fun get(module: Module) = with(module) {
        getViewModels(this)
        getServices(this)
        getRepositories(this)
        getUseCases(this)
    }

    private fun getServices(module: Module) = with(module) {
        single(named("UiStateService")) {
            HTTPClient.create(
                OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build(),
                UI_STATE_BASE_URL,
                UiStateService::class
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