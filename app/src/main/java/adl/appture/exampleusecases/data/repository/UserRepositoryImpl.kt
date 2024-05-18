package adl.appture.exampleusecases.data.repository

import adl.appture.exampleusecases.data.api.networking.UserDataSource
import adl.appture.exampleusecases.domain.repository.UserRepository

class UserRepositoryImpl(private val userDataSource: UserDataSource): UserRepository {
    override suspend fun getUserProfileImage(userId: String): String {
        return userDataSource.getUserProfilePicture(userId = userId)
    }
}