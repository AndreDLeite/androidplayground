package adl.appture.uistates.data.remote.api.service

import retrofit2.http.GET

fun interface UiStateService {

    @GET("api/users")
    suspend fun getRandomPlaceHolder()

}
