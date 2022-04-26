package adl.appture.playground.camera.ui

import adl.appture.playground.R
import adl.appture.playground.camera.utils.ImageUtils
import adl.appture.playground.databinding.FragmentCameraMainBinding
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment

class CameraMainFragment: Fragment(R.layout.fragment_camera_main) {

    private lateinit var binding: FragmentCameraMainBinding
    private var imageUri: Uri? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCameraMainBinding.bind(view)
        setupViewListeners()
    }

    private fun setupViewListeners() {
        binding.btTakePicture.setOnClickListener {
            takePicture()
        }
    }

    private fun takePicture() {
        ImageUtils.createImageFile(requireContext())?.also {
            imageUri = FileProvider.getUriForFile(
                requireContext(),
                requireContext().packageName,
                it
            )
            takePictureRegistration.launch(imageUri)
        }
    }

    private val takePictureRegistration =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
            if (isSuccess) {
//                mBinding.photoPreview.setImageURI(imageUri)
            }
        }

}