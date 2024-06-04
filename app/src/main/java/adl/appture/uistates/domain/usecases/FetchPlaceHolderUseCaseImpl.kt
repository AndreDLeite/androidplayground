package adl.appture.uistates.domain.usecases

import adl.appture.uistates.domain.repository.UiStateRepository
import adl.appture.uistates.ui.states.UiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class FetchPlaceHolderUseCaseImpl(
    private val repository: UiStateRepository,
    private val dispatcher: CoroutineDispatcher
) : FetchPlaceHolderUseCase {

    override fun fetchInformation(): Flow<UiState<Unit>> = flow {
        emit(UiState.Loading)
        try {
            val response = repository.fetchInformation()
            emit(UiState.Success(response))
        } catch (e: Exception) {
            emit(UiState.Failure("error loading usecase"))
        }
    }.flowOn(dispatcher)

}
