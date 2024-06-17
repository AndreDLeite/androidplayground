package adl.appture.uistates.data.remote.networking

import adl.appture.uistates.data.remote.api.service.UiStateService

class UiStateServiceImpl(
    private val webService: UiStateService,
): UiStateService {

    override suspend fun getRandomPlaceHolder() {
        webService.getRandomPlaceHolder()
    }
}