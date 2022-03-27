package com.deu.aifitness.component.carousel

import android.content.Context
import android.util.AttributeSet
import android.util.Base64
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.coroutineScope
import com.bumptech.glide.Glide
import com.deu.aifitness.R
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.databinding.ComponentCarouselBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * TODO: document your custom view class.
 */
class Carousel : ConstraintLayout {

    lateinit var binding:ComponentCarouselBinding
    var carouselImageListener:CarouselImageListener? = null
    private var imageList = mutableListOf<String>()
    private var currentIndex = MutableLiveData(0)
    private var animationWay = CarouselAnimationWay.NONE
    var uploadedImages = MutableLiveData(mutableListOf<Boolean>())

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        for (index in 0 until 3) { imageList.add(Constant.uploadImage) }
        for (index in 0 until 3) { uploadedImages.value?.add(false) }
        binding = DataBindingUtil.inflate(
             LayoutInflater.from(context),
             R.layout.component_carousel,
             this,
             true
        )
        uploadImage()
        binding.apply {
            firstImagePagination.setOnClickListener(paginationButtonsListener)
            secondImagePagination.setOnClickListener(paginationButtonsListener)
            thirdImagePagination.setOnClickListener(paginationButtonsListener)
            nextButton.setOnClickListener(nextButtonListener)
            backButton.setOnClickListener(nextButtonListener)
            paginationImage.setOnClickListener(imageListener)
        }
        if (!currentIndex.hasActiveObservers()){
            currentIndex.observe((context as LifecycleOwner)) {
                changeCarouselIndex(it)
            }
        }
    }

    private fun uploadImage(){
        changeUploadedImagesStatus()
        if (currentIndex.value!! < imageList.size){
            val imageBase64 = imageList[currentIndex.value!!]
            val imageByteArray: ByteArray = Base64.decode(imageBase64, Base64.DEFAULT)
            Glide.with(context).asBitmap().load(imageByteArray).into(binding.paginationImage)
        }
    }

    private val nextButtonListener = OnClickListener { view->
        var oldIndex = currentIndex.value
        if (oldIndex != null) {
            when(view.id){
                R.id.nextButton ->{
                    oldIndex+=1
                    animationWay = CarouselAnimationWay.RIGHT_TO_LEFT
                }
                R.id.backButton ->{
                    oldIndex-=1
                    animationWay = CarouselAnimationWay.LEFT_TO_RIGHT
                }
            }
            if (oldIndex>2){
                oldIndex %= 1
            }else if(oldIndex < 0){
                oldIndex = 2
            }
            currentIndex.value = oldIndex
        }else{
            currentIndex.value = 0
        }
    }

    private val imageListener = OnClickListener {
        currentIndex.value?.let { it1 -> carouselImageListener?.imageClicked(it1) }
    }

    private fun changeUploadedImagesStatus(){
        val list = uploadedImages.value
        list?.let {
            it[currentIndex.value!!] = true
        }
        uploadedImages.value = list
    }

    fun setImage(imageBase64:String,comingFromInside:Boolean){
        if (!comingFromInside)
            changeUploadedImagesStatus()
        if (currentIndex.value!! < imageList.size){
            imageList[currentIndex.value!!] = imageBase64
            val imageByteArray: ByteArray = Base64.decode(imageBase64, Base64.DEFAULT)
            (context as LifecycleOwner).lifecycle.coroutineScope.launch {
                Glide.with(context).asBitmap().load(imageByteArray).into(binding.paginationImage)
            }
        }
    }

    private fun changeCarouselIndex(value:Int){
        when(value){
            0 ->{
                selectPagination(binding.firstImagePagination)
                notSelectPagination(binding.secondImagePagination)
                notSelectPagination(binding.thirdImagePagination)
            }
            1 ->{
                selectPagination(binding.secondImagePagination)
                notSelectPagination(binding.firstImagePagination)
                notSelectPagination(binding.thirdImagePagination)
            }
            2 ->{
                selectPagination(binding.thirdImagePagination)
                notSelectPagination(binding.secondImagePagination)
                notSelectPagination(binding.firstImagePagination)
            }
        }
        if (animationWay == CarouselAnimationWay.RIGHT_TO_LEFT){
            val animation = AnimationUtils.loadAnimation(context, R.anim.left_to_right_animation)
            animation.setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    if (currentIndex.value!! < imageList.size){
                        setImage(imageList[currentIndex.value!!],true)
                    }
                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })
            binding.paginationImage.startAnimation(animation)
        }else if (animationWay == CarouselAnimationWay.LEFT_TO_RIGHT){
            val animation = AnimationUtils.loadAnimation(context, R.anim.right_to_left_animation)
            animation.setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    if (currentIndex.value!! < imageList.size){
                        setImage(imageList[currentIndex.value!!],true)
                    }
                }
                override fun onAnimationRepeat(animation: Animation?) {}
            })
            binding.paginationImage.startAnimation(animation)
        }
    }

    private val paginationButtonsListener = OnClickListener { button->
        when(button.id){
            R.id.firstImagePagination ->{
                currentIndex.value = 0
                selectPagination(binding.firstImagePagination)
                notSelectPagination(binding.secondImagePagination)
                notSelectPagination(binding.thirdImagePagination)
            }
            R.id.secondImagePagination ->{
                currentIndex.value = 1
                selectPagination(binding.secondImagePagination)
                notSelectPagination(binding.firstImagePagination)
                notSelectPagination(binding.thirdImagePagination)
            }
            R.id.thirdImagePagination ->{
                currentIndex.value = 2
                selectPagination(binding.thirdImagePagination)
                notSelectPagination(binding.secondImagePagination)
                notSelectPagination(binding.firstImagePagination)
            }
        }
    }

    private fun selectPagination(button:AppCompatButton){
        button.setBackgroundResource(R.drawable.bg_carousel_selected)
    }

    private fun notSelectPagination(button:AppCompatButton){
        button.setBackgroundResource(R.drawable.bg_carousel_not_selected)
    }

    fun getImages():List<String> = this.imageList

    fun setImages(imageList:List<String>){
        this.imageList = imageList.toMutableList()
        uploadImage()
    }

    interface CarouselImageListener{
        fun imageClicked(imageIndex:Int)
    }
}