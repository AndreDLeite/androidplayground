package adl.appture.playground.firebase.ui

import adl.appture.playground.R
import adl.appture.playground.databinding.FragmentFirebaseMainBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FirebaseMainFragment : Fragment(R.layout.fragment_firebase_main) {

    private var _binding: FragmentFirebaseMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirebaseMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewListeners()
    }

    private fun setupViewListeners() {
        binding.mbtFirebaseSample.setOnClickListener {
            activity?.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
