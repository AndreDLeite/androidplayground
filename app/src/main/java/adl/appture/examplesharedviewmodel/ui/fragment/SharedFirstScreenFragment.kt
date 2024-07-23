package adl.appture.examplesharedviewmodel.ui.fragment

import adl.appture.examplesharedviewmodel.ui.viewmodel.SharedViewModelExample
import adl.appture.extensions.launchWhenResumedFromFragment
import adl.appture.extensions.useSingleClickAction
import adl.appture.playground.R
import adl.appture.playground.databinding.FragmentSharedViewmodelFirstBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SharedFirstScreenFragment : Fragment(R.layout.fragment_shared_viewmodel_first) {

    private val viewModel by sharedViewModel<SharedViewModelExample>()
    private lateinit var binding: FragmentSharedViewmodelFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSharedViewmodelFirstBinding.bind(view)
        setupViewListeners()
        setupViewModelListeners()
    }

    private fun setupViewListeners() {
        binding.mbtAdd.setOnClickListener {
            viewModel.addValue()
        }

        binding.mbtNavigateToSecond.useSingleClickAction {
            navigateToSecondSharedFragment()
        }

        binding.acibBack.useSingleClickAction {
            activity?.finish()
        }
    }

    private fun setupViewModelListeners() {
        launchWhenResumedFromFragment {
            viewModel.stateFlowCount.collectLatest { value ->
                binding.tvSharedValue.text = "First Fragment Value: \n $value"
            }
        }

    }

    private fun navigateToSecondSharedFragment() {
        findNavController().navigate(SharedFirstScreenFragmentDirections.actionFragmentFirstToSecondNavigation())
    }

}
