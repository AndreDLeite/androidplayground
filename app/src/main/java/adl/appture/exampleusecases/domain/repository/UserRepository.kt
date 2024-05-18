package adl.appture.exampleusecases.domain.repository

fun interface UserRepository {
    suspend fun getUserProfileImage(userId: String): String
}