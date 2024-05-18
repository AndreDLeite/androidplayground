package adl.appture.exampleusecases.data.api.networking

fun interface UserDataSource {
    suspend fun getUserProfilePicture(userId: String): String
}
