package adl.appture.uistates.data.repository

import adl.appture.uistates.data.remote.api.service.UiStateService
import adl.appture.uistates.domain.repository.UiStateRepository

class UiStateRepositoryImpl(private val uiStateService: UiStateService): UiStateRepository {
    override suspend fun fetchInformation() {
        return uiStateService.getRandomPlaceHolder()
    }
}