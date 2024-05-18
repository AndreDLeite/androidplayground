package adl.appture.exampleusecases.data.api.networking

class UserDataSourceImpl: UserDataSource {
    override suspend fun getUserProfilePicture(userId: String): String {
        return ""
    }
}