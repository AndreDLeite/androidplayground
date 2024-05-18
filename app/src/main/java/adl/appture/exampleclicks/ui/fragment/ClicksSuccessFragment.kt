package adl.appture.exampleclicks.ui.fragment

import adl.appture.extensions.useSingleClickAction
import adl.appture.playground.R
import adl.appture.playground.databinding.FragmentClicksSuccessBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class ClicksSuccessFragment: Fragment(R.layout.fragment_clicks_success) {

    private var _binding: FragmentClicksSuccessBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentClicksSuccessBinding.bind(view)
        setupViewListeners()
    }


    private fun setupViewListeners() {
        binding.acibBack.useSingleClickAction {
            requireActivity().onBackPressed()
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
