package adl.appture.examplesharedviewmodel.ui.fragment

import adl.appture.examplesharedviewmodel.ui.viewmodel.SharedViewModelExample
import adl.appture.extensions.launchWhenResumedFromFragment
import adl.appture.extensions.useSingleClickAction
import adl.appture.playground.R
import adl.appture.playground.databinding.FragmentSharedViewmodelSecondBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SharedSecondScreenFragment : Fragment(R.layout.fragment_shared_viewmodel_second) {

    private val viewModel by sharedViewModel<SharedViewModelExample>()
    private lateinit var binding: FragmentSharedViewmodelSecondBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSharedViewmodelSecondBinding.bind(view)
        setupViewListeners()
        setupViewModelListeners()
    }

    private fun setupViewListeners() {
        binding.acibBack.useSingleClickAction {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }

        binding.mbtSubtract.setOnClickListener {
            viewModel.subtractValue()
        }
    }

    private fun setupViewModelListeners() {
        launchWhenResumedFromFragment {
            viewModel.stateFlowCount.collectLatest { value ->
                binding.tvSharedValue.text = "Second Fragment Value: \n $value"
            }
        }
    }

}
