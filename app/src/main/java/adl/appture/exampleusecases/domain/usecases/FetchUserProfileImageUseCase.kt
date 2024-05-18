package adl.appture.exampleusecases.domain.usecases

fun interface FetchUserProfileImageUseCase {
    suspend operator fun invoke(userId: String): String
}



