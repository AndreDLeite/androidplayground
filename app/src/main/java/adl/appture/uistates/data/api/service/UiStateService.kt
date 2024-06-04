package adl.appture.uistates.data.api.service

import retrofit2.http.GET

fun interface UiStateService {

    @GET("")
    suspend fun getRandomPlaceHolder()

}
