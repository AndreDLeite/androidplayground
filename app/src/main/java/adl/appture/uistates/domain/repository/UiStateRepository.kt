package adl.appture.uistates.domain.repository

fun interface UiStateRepository {
    suspend fun fetchInformation()
}