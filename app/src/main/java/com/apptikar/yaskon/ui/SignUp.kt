package com.apptikar.yaskon.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.apptikar.yaskon.R
import com.apptikar.yaskon.databinding.ActivitySignUpBinding
import com.facebook.*
import com.facebook.Profile
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class SignUp : AppCompatActivity() {
    private  lateinit var binding: ActivitySignUpBinding
    private lateinit var callBackManger:CallbackManager
    private val viewModel: SignUpViewModel by viewModels()
    private var callbackManager: CallbackManager? = null
   private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val task =   GoogleSignIn.getSignedInAccountFromIntent(data)
            val account = task.getResult(ApiException::class.java)
          viewModel.emailMutable.value =  account?.email
          viewModel.nameMutable.value = account?.displayName
           viewModel.accessToken.value =  account?.idToken
            viewModel.accountType.value = "google"
} }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.viewModel = viewModel
        setSpinnerCustomAdapter()
        FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS)
        binding.facebookSignUp.setOnClickListener {
           signInWithFacebook()
        }

        binding.googleSignUp.setOnClickListener {
            signInWithGoogle()
        }

        binding.signUpButton.setOnClickListener {
            viewModel.nameMutable.value = binding.nameInputLayout.editText?.text.toString()
            viewModel.emailMutable.value = binding.emailInputLayout.editText?.text.toString()
            viewModel.phoneNumberMutable.value = binding.phoneInputLayout.editText?.text.toString()
            viewModel.passwordMutable.value =    binding.passwordInputLayout.editText?.text.toString()
            viewModel.countryCodeMutable.value = binding.spinner2.selectedItem.toString()
            viewModel.accountType.value = "YaskonUser"
        }


    }

    private fun setSpinnerCustomAdapter()
    {
        val countryCodes = resources.getStringArray(R.array.country)
        val arrayList = countryCodes.toSortedSet().toList()
        val adapter = ArrayAdapter(this, R.layout.custom_spinner_item2, arrayList)
        adapter.setDropDownViewResource(R.layout.custom_spinner_item2)
        binding.spinner2.adapter = adapter
    }

    private  fun signInWithGoogle()
    {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestIdToken(
            getString(
                R.string.idToken
            )
        ).build()
       val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        signIn(mGoogleSignInClient)
    }

    private fun signIn(mGoogleSignInClient: GoogleSignInClient) {
          val intent =   mGoogleSignInClient.signInIntent
      resultLauncher.launch(intent)
    }

    private fun signInWithFacebook()
    {
        callBackManger = CallbackManager.Factory.create()

        LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))
        LoginManager.getInstance().registerCallback(callBackManger,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(loginResult: LoginResult) {
                       viewModel.accessToken.value = loginResult.accessToken.token
                        val  profile = Profile.getCurrentProfile()
                       val facebookId =  profile.id
                      val firstName =  profile.firstName
                      val middleName =   profile.middleName
                       val pictureUrl =  "https://graph.facebook.com/" +Profile.getCurrentProfile().id + "/picture?type=large"
                        Log.d("abdo",firstName)
                    }
                    override fun onCancel() {
                     
                    }

                    override fun onError(exception: FacebookException) {
                    
                    }
                })
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callBackManger.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)

    }


    }
