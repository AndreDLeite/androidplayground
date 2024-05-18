package adl.appture.exampleclicks.ui.fragment

import adl.appture.exampleclicks.ui.viewmodel.ClicksViewModel
import adl.appture.extensions.useSingleClickAction
import adl.appture.playground.R
import adl.appture.playground.databinding.FragmentClicksMainBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClicksMainFragment : Fragment(R.layout.fragment_clicks_main) {

    private var _binding: FragmentClicksMainBinding? = null
    private val binding get() = _binding!!

    private val clicksViewModel: ClicksViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentClicksMainBinding.bind(view)
        setupViewListeners()
        setupViewObservers()


        view.setOnClickListener {
            //Do your Work Here
        }
    }


    private fun setupViewListeners() {
        binding.mbtFastCard.setOnClickListener {
            clicksViewModel.addToMultipleClicks()
        }

        binding.mbtSlowCard.useSingleClickAction {
            clicksViewModel.addToSingleClicks()
        }

        binding.acibBack.useSingleClickAction {
            requireActivity().onBackPressed()
        }

        binding.tvFastCardValue.setOnClickListener {
            clicksViewModel.addToSingleClicks()
        }

        binding.mbtFastCardNavigation.setOnClickListener {
            clicksViewModel.handleNavigationClick()
        }

        binding.mbtSlowCardNavigation.useSingleClickAction {
            clicksViewModel.handleNavigationClick()
        }
    }

    private fun navigateToSuccessScreen() {
        findNavController().navigate(ClicksMainFragmentDirections.actionFragmentClicksMainToFragmentClicksSuccessNavigation())
    }

    private fun setupViewObservers() {
        with(clicksViewModel) {
            multipleClickCounter.observe(viewLifecycleOwner) { value ->
                value ?: return@observe
                binding.tvFastCardValue.text = "%s times clicked".format(value.toString())
            }

            singleClickCounter.observe(viewLifecycleOwner) { value ->
                value ?: return@observe
                binding.tvSlowCardValue.text = "%s times clicked".format(value.toString())
            }

            canNavigate.observe(viewLifecycleOwner) { canNavigate ->
                canNavigate ?: return@observe
                if (canNavigate) {
                    navigateToSuccessScreen()
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
