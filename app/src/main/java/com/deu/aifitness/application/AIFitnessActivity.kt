package com.deu.aifitness.application

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.camera.camera2.Camera2Config
import androidx.camera.core.CameraXConfig
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.Observer
import com.deu.aifitness.BR
import com.deu.aifitness.R
import com.deu.aifitness.data.constant.Constant
import com.deu.aifitness.data.constant.SelectButtons
import com.deu.aifitness.databinding.ActionBarBinding
import com.deu.aifitness.ui.settings.SettingsActivity
import com.deu.aifitness.ui.tabbar.TabbarFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import dagger.android.AndroidInjection
import java.lang.Exception

abstract class AIFitnessActivity<VM:AIFitnessVM,DB:ViewDataBinding>:AppCompatActivity(),
    CameraXConfig.Provider {

    abstract fun getLayoutId():Int

    abstract fun getLayoutVM():VM

    private fun getContainerId() = R.id.container

    private fun getTabbarContainerId() = R.id.tabbarContainer

    open fun hasSelectButton() = false

    open fun hasBackButton() = false

    open fun hasSettingButton() = false

    open fun selectButton1Text() = R.string.login_button

    open fun selectButton2Text() = R.string.register_button

    lateinit var googleSignInClient: GoogleSignInClient
    lateinit var activityResultLauncher:ActivityResultLauncher<Intent>

    protected var viewModel:VM? = null
    protected var binding:DB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        registerActivityResult()
        viewModel = getLayoutVM()
        binding = DataBindingUtil.setContentView(this,getLayoutId())
        binding!!.setVariable(BR.viewModel,viewModel)
        (viewModel as AIFitnessVM).let{ vm->
                if(!vm.state.hasActiveObservers()){
                    vm.state.observe(this, Observer {
                        stateChange(vm.state.value)
                    })
                }
        }
    }
    fun startActivity(classAI:Class<*>){
        val intent = Intent(this,classAI)
        startActivity(intent)
    }

    fun getCurrentFragment():AIFitnessFragment<*,*>?{
        val currentFragment = supportFragmentManager.findFragmentById(getContainerId())
        if (currentFragment != null){
            return  currentFragment as AIFitnessFragment<*, *>
        }
        return null
    }

    override fun onBackPressed() {
        val result = back()
        if (result == -1){
            super.onBackPressed()
        }
    }

    fun changeButtonState(buttonState:SelectButtons){
        if (buttonState == SelectButtons.SELECT_BUTTON2){
            findViewById<RadioButton>(R.id.selectButtonRB).background =
                ContextCompat.getDrawable(this,R.drawable.bg_not_selected_button)
            findViewById<RadioButton>(R.id.selectButton2RB).background =
                ContextCompat.getDrawable(this,R.drawable.bg_selected_button)
        }else if (buttonState == SelectButtons.SELECT_BUTTON1){
            findViewById<RadioButton>(R.id.selectButtonRB).background =
                ContextCompat.getDrawable(this,R.drawable.bg_selected_button)
            findViewById<RadioButton>(R.id.selectButton2RB).background =
                ContextCompat.getDrawable(this,R.drawable.bg_not_selected_button)
        }

    }

    fun setAppBar(){
        findViewById<RadioGroup>(R.id.radioGroup).visibility = if(hasSelectButton()) View.VISIBLE else View.GONE
        findViewById<RadioButton>(R.id.selectButtonRB).text = getString(selectButton1Text())
        findViewById<RadioButton>(R.id.selectButton2RB).text = getString(selectButton2Text())
        val backButton = findViewById<ImageButton>(R.id.backButtonIB)
        backButton.setOnClickListener(backButtonListener)
        backButton.visibility = if (hasBackButton()) View.VISIBLE else View.GONE
        val settingsButton = findViewById<ImageButton>(R.id.settingButtonIB)
        settingsButton.setOnClickListener(settingsButtonListener)
        settingsButton.visibility = if (hasSettingButton()) View.VISIBLE else View.GONE

    }

    fun setAppBarFromFragment(selectButtonFlag:Boolean,selectButton1Text:String,selectButton2Text:String,
                              backButtonFlag:Boolean,settingButton:Boolean){
        findViewById<RadioGroup>(R.id.radioGroup).visibility = if(selectButtonFlag) View.VISIBLE else View.GONE
        findViewById<RadioButton>(R.id.selectButtonRB).text = selectButton1Text
        findViewById<RadioButton>(R.id.selectButton2RB).text = selectButton2Text
        val backButton = findViewById<ImageButton>(R.id.backButtonIB)
        backButton.setOnClickListener(backButtonListener)
        backButton.visibility = if (backButtonFlag) View.VISIBLE else View.GONE
        val settingsButton = findViewById<ImageButton>(R.id.settingButtonIB)
        settingsButton.setOnClickListener(settingsButtonListener)
        settingsButton.visibility = if (settingButton) View.VISIBLE else View.GONE

    }

    fun setSelectButton1Listener(listener:View.OnClickListener){
        findViewById<RadioButton>(R.id.selectButtonRB).setOnClickListener(listener)
    }

    fun setSelectButton2Listener(listener:View.OnClickListener){
        findViewById<RadioButton>(R.id.selectButton2RB).setOnClickListener(listener)
    }

    private fun back():Int{
        val currentFragment = getCurrentFragment()
         if (currentFragment != null){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.remove(currentFragment)
            fragmentTransaction.commitAllowingStateLoss()
            supportFragmentManager.popBackStackImmediate()
            if (supportFragmentManager.backStackEntryCount == 0) {
                return -1
            }
             return 0
        }else{
             return -1
        }

    }

    fun startActivityWithString(classAI: Class<*>,variable:String){
        val intent = Intent(this,classAI)
        intent.putExtra(Constant.paramName,variable)
        startActivity(intent)
    }

    fun addFragment(fragment:AIFitnessFragment<*,*>){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(getContainerId(),fragment,null)
        fragmentTransaction.commitAllowingStateLoss()
    }

    fun replaceFragment(fragment:AIFitnessFragment<*,*>){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(getContainerId(),fragment,null)
        fragmentTransaction.commitAllowingStateLoss()
    }

    fun addTabbarFragment(fragment:AIFitnessFragment<*,*>){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(getTabbarContainerId(),fragment,null)
        fragmentTransaction.commitAllowingStateLoss()
    }

    open fun stateChange(state:AIFitnessState?){

    }

    private val backButtonListener = View.OnClickListener{
        finish()
    }

    private val settingsButtonListener = View.OnClickListener {
        startActivity(SettingsActivity::class.java)
    }

    fun signInGoogleLauncher() {
        getFirebaseAuth()

        val intent = googleSignInClient.signInIntent
        activityResultLauncher.launch(intent)
    }

    fun registerActivityResult(){
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                val data = it.data
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                handleResult(task)
            }
        }
    }

    private fun handleResult(task: Task<GoogleSignInAccount>){
        task.addOnSuccessListener(object: OnSuccessListener<GoogleSignInAccount>{
            override fun onSuccess(p0: GoogleSignInAccount?) {
                val id = p0?.email
                Toast.makeText(applicationContext,"Success login with $id",Toast.LENGTH_LONG).show()
            }
        }).addOnFailureListener(object: OnFailureListener{
            override fun onFailure(p0: Exception) {
                // burada hata mesajı verilmeli
            }

        })
    }


    private fun getFirebaseAuth(){
        val ai = applicationContext.packageManager.getApplicationInfo(applicationContext.packageName,PackageManager.GET_META_DATA)
        val metaData = ai.metaData
        val requestToken = metaData.get("google_client_id") as String
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(requestToken)
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(applicationContext, gso)
    }
    override fun getCameraXConfig(): CameraXConfig {
        return CameraXConfig.Builder.fromConfig(Camera2Config.defaultConfig())
            .setMinimumLoggingLevel(Log.ERROR).build()
    }
}