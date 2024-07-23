package adl.appture.views.ui.fragments

import adl.appture.extensions.useSingleClickAction
import adl.appture.playground.R
import adl.appture.playground.databinding.FragmentViewsBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class ViewsFragment: Fragment(R.layout.fragment_views) {

    private var _binding: FragmentViewsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentViewsBinding.bind(view)
        setupViewInteraction()

    }

    private fun setupViewInteraction() {
        binding.acibBack.useSingleClickAction {
            requireActivity().onBackPressed()
        }
    }

}
