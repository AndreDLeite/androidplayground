package adl.appture.playground.ui.fragments

import adl.appture.extensions.launchWhenResumedFromFragment
import adl.appture.playground.R
import adl.appture.playground.databinding.FragmentHomeMainBinding
import adl.appture.playground.domain.model.HomeCardEnum
import adl.appture.playground.domain.model.HomeCardEnum.*
import adl.appture.playground.domain.model.HomeCardModel
import adl.appture.playground.ui.adapters.HomeActionsAdapter
import adl.appture.playground.viewmodel.HomeViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home_main), HomeActionsAdapter.CardActionsListener {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeMainBinding.bind(view)
        setupCardsObserver()
    }

    private fun setupRecyclerView(cardList: List<HomeCardModel>) {
        binding.rvAppOptions.adapter = HomeActionsAdapter(cardList, this)
    }

    private fun setupCardsObserver() {
        launchWhenResumedFromFragment {
            homeViewModel.homeCards.collectLatest {  cardList ->
                setupRecyclerView(cardList)
            }
        }
    }

    override fun onCardClicked(cardType: HomeCardEnum) {
        when (cardType) {
            CAMERA -> navigateToCameraModule()
            COMPONENTS -> {
                // Adicionar o start navigation correto no navigation_components
                //navigateToComponentsModel()
            }

            FIREBASE -> navigateToFirebaseModule()
            CLICKS -> navigateToClicksModule()
            VIEWS -> {
                navigateToViews()
            }

            SHARED_VIEW_MODEL -> navigateToSharedViewModelExample()
        }
    }

    private fun navigateToSharedViewModelExample() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSharedViewmodelNavGraph())
    }

    private fun navigateToCameraModule() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCameraNavGraph())
    }

    private fun navigateToComponentsModel() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToComponentsNavGraph())
    }

    private fun navigateToFirebaseModule() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFirebaseNavGraph())
    }

    private fun navigateToClicksModule() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToClicksNavGraph())
    }

    private fun navigateToViews() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToViewsNavGraph())
    }

}