package com.deu.aifitness.ui.profile

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.deu.aifitness.R
import com.deu.aifitness.application.AIFitnessFragment
import com.deu.aifitness.application.AIFitnessState
import com.deu.aifitness.data.profile.ProfileEntity
import com.deu.aifitness.data.profile.UpdateProfileImageRequest
import com.deu.aifitness.data.profile.UpdateProfileRequest
import com.deu.aifitness.databinding.FragmentProfileBinding
import java.io.ByteArrayOutputStream
import javax.inject.Inject


class ProfileFragment : AIFitnessFragment<ProfileVM,FragmentProfileBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun getLayoutVM(): ProfileVM = profileVM

    @Inject
    lateinit var profileVM: ProfileVM

    lateinit var getContent : ActivityResultLauncher<String>

    private var newProfileImage:String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  super.onCreateView(inflater, container, savedInstanceState)
        showProgress()
        registerActivityResultLauncher()
        viewModel?.getProfile()
        binding?.editButtonBTN?.setOnClickListener(buttonListener)
        binding?.profileImageIV?.setOnClickListener(imageViewListener)
        return view
    }

    override fun stateChange(state: AIFitnessState) {
        when(state){
            is ProfileVS.SetProfile ->{
                showProgress()
                setProfile(state.profile)
            }
            ProfileVS.PositiveResponseFromUpdateProfile ->{
                showProgress()
                if (newProfileImage != null){
                    viewModel?.updateProfileImage(UpdateProfileImageRequest("",newProfileImage!!))
                }else{
                    viewModel?.getProfile()
                }
            }
            ProfileVS.PositiveResponseFromUpdateProfileImage ->{
                viewModel?.getProfile()
            }
            ProfileVS.Error ->{
                showErrorProgress()
                showNetworkError()
            }
        }
    }

    private fun setProfile(profile: ProfileEntity){
        safeLet(profile.email,profile.phoneNumber){ email,phoneNumer->
            binding?.emailAET?.setText(profile.email)
            binding?.phoneAET?.setText(profile.phoneNumber)

        }
        if(!profile.userPhoto.isEmpty()){
            binding?.profileImageIV?.let {
                val imageByteArray: ByteArray = Base64.decode(profile.userPhoto, Base64.DEFAULT)
                Glide.with(requireContext()).asBitmap().load(imageByteArray).into(it)
            }
        }
    }

    private val imageViewListener = View.OnClickListener {
        getContent.launch("image/*")
    }

    private val buttonListener = View.OnClickListener{
        val newProfile = UpdateProfileRequest( "",binding?.phoneAET?.getText() ?: ""
            ,binding?.emailAET?.getText() ?: "")
        viewModel?.updateProfile(newProfile)
    }

    private fun registerActivityResultLauncher(){
        getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            setImage(uri)
        }
    }

    private fun setImage(uri: Uri?) {
        Glide.with(requireContext()).asBitmap().load(uri)
            .listener(object: RequestListener<Bitmap>{
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
                    getAIFitnessActivity()?.runOnUiThread {
                        binding?.profileImageIV?.setImageBitmap(resource)
                    }
                    resource?.let { newProfileImage = convertToBase64(it) }
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
}