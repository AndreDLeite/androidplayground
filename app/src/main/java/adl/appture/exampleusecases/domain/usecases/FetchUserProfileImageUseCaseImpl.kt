package adl.appture.exampleusecases.domain.usecases

import adl.appture.exampleusecases.domain.repository.UserRepository

class FetchUserProfileImageUseCaseImpl(private val userRepository: UserRepository):
    FetchUserProfileImageUseCase {
    override suspend fun invoke(userId: String): String {
        return userRepository.getUserProfileImage(userId)
    }
}


