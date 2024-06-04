package adl.appture.uistates.ui.fragments

import adl.appture.uistates.ui.states.UiState
import adl.appture.uistates.ui.viewmodel.UiStateViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class UiStateFragment : Fragment() {

    private val viewModel: UiStateViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewObservers()
        viewModel.fetchInformation()
    }

    private fun setupViewObservers() {
        viewModel.informationState.observe(viewLifecycleOwner) { information ->
            information ?: return@observe

            when(information) {
                is UiState.Loading -> {
                    //TODO: Set UI Loading state
                }
                is UiState.Success -> {
                    //TODO: Set UI Success state
                }
                is UiState.Failure -> {
                    //TODO: Set UI Failure state
                }
            }
        }
    }

}