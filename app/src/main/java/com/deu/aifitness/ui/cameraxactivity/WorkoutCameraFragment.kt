package com.deu.aifitness.ui.cameraxactivity

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.view.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.component.carousel.Carousel
import com.deu.aifitness.data.workout.UploadWorkoutRequest
import com.deu.aifitness.databinding.FragmentWorkoutCameraBinding
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import javax.inject.Inject


class WorkoutCameraFragment : AIFitnessFragment<WorkoutCameraFragmentVM,FragmentWorkoutCameraBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_workout_camera

    override fun getLayoutVM(): WorkoutCameraFragmentVM = cameraFragmentVM

    override fun hasBackButton(): Boolean = true


    @Inject
    lateinit var cameraFragmentVM: WorkoutCameraFragmentVM
    lateinit var getContent : ActivityResultLauncher<String>

    private var currentImage:String = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        setAppBar()
        registerActivityResultLauncher()
        if(binding?.carouselC?.uploadedImages?.hasActiveObservers() == false){
            binding?.carouselC?.uploadedImages?.observe(viewLifecycleOwner){
                uploadedImagesStatus(it.toList())
            }
        }
        binding?.apply {
            submitButtonBTN.setOnClickListener(uploadButtonListener)
            carouselC.carouselImageListener = carouselImageListener
        }
        return view
    }

    private fun uploadedImagesStatus(imagesStatus:List<Boolean>){
        imagesStatus.forEach {
            if (!it){
                return
            }
        }
        binding?.statusMessageTV?.setText(R.string.finish_upload_image_text)
        binding?.submitButtonBTN?.isEnabled = true
    }

    override fun stateChange(state: AIFitnessState) {
        when(state){
            WorkoutCameraFragmentVS.ImageUploaded ->{
                viewModel?.startWaiting()
            }
            WorkoutCameraFragmentVS.StartWaiting ->{
            }
            is WorkoutCameraFragmentVS.ResultCame ->{
                showProgress()
                setResult(state.uploadWorkoutRequest)
            }
            WorkoutCameraFragmentVS.Error ->{
                showErrorProgress()
            }
        }
    }

    private fun setResult(uploadWorkoutRequest: UploadWorkoutRequest){
        binding?.carouselC?.setImages(uploadWorkoutRequest.workoutImages)
    }

    private val carouselImageListener = object :Carousel.CarouselImageListener{
        override fun imageClicked(imageIndex: Int) {
            getContent.launch("image/*")
        }
    }

    private fun registerActivityResultLauncher(){
        getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            setImage(uri)
        }
    }

    private fun sendImageToCarousel(){
        lifecycleScope.launch {
            binding?.carouselC?.setImage(currentImage,false)
        }
    }

    private fun setImage(uri: Uri?) {
        Glide.with(requireContext()).asBitmap().load(uri)
            .listener(object: RequestListener<Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    isFirstResource: Boolean
                ): Boolean {
                    print(e?.localizedMessage)
                    return false
                }

                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    resource?.let { currentImage = (convertToBase64(it)) }
                    sendImageToCarousel()
                    return true
                }
            }).submit()
    }

    fun convertToBase64(bitmap: Bitmap):String{
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray: ByteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    private val uploadButtonListener = View.OnClickListener {
        showProgress()
        binding?.carouselC?.getImages()?.let { it1 -> viewModel?.uploadImages(UploadWorkoutRequest(it1)) }
    }

}