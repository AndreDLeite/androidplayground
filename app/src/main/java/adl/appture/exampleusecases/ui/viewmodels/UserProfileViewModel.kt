package adl.appture.exampleusecases.ui.viewmodels

import adl.appture.exampleusecases.domain.usecases.FetchUserProfileImageUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserProfileViewModel(private val fetchUserProfileImageUseCase: FetchUserProfileImageUseCase): ViewModel() {

    fun fetchUserProfileImage() {
        viewModelScope.launch {
            fetchUserProfileImageUseCase.invoke(String())
        }
    }

}


