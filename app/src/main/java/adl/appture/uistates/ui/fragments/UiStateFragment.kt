package adl.appture.uistates.ui.fragments

import adl.appture.extensions.launchWhenResumedFromFragment
import adl.appture.uistates.ui.states.UiState
import adl.appture.uistates.ui.viewmodel.UiStateViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class UiStateFragment : Fragment() {

    private val viewModel: UiStateViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewObservers()
        viewModel.fetchInformation()
    }

    private fun setupViewObservers() {
        launchWhenResumedFromFragment {
            viewModel.sharedStateFlow.collectLatest { uiState ->
                when (uiState) {
                    is UiState.Loading -> {

                    }

                    is UiState.Success -> {

                    }

                    is UiState.Failure -> {

                    }
                }
            }

            viewModel.stateFlowResponse.collectLatest { uiState ->
                when (uiState) {
                    is UiState.Loading -> {

                    }

                    is UiState.Success -> {

                    }

                    is UiState.Failure -> {

                    }
                }
            }
        }
    }

}