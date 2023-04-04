package adl.appture.playground.ui.fragments

import adl.appture.playground.R
import adl.appture.playground.domain.model.HomeCardEnum
import adl.appture.playground.domain.model.HomeCardModel
import adl.appture.playground.ui.adapters.HomeActionsAdapter
import adl.appture.playground.viewmodel.HomeViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home_main), HomeActionsAdapter.CardActionsListener {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var rvAppOptions: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupCardsObserver()
    }

    private fun initViews(fragmentView: View) {
        rvAppOptions = fragmentView.findViewById(R.id.rv_app_options)
    }

    private fun setupRecyclerView(cardList: List<HomeCardModel>) {
        rvAppOptions.adapter = HomeActionsAdapter(cardList, this)
    }

    private fun setupCardsObserver() {
        homeViewModel.homeCards.observe(viewLifecycleOwner) { cardList ->
            cardList ?: return@observe
            setupRecyclerView(cardList)
        }
    }

    override fun onCardClicked(cardType: HomeCardEnum) {
        when(cardType) {
            HomeCardEnum.CAMERA -> navigateToCameraModule()
            HomeCardEnum.COMPONENTS -> {
                // Adicionar o start navigation correto no navigation_components
                //navigateToComponentsModel()
            }
            HomeCardEnum.FIREBASE -> navigateToFirebaseModule()
        }
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

}