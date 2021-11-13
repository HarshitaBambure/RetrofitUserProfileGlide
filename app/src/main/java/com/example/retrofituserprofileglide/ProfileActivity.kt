package com.example.retrofituserprofileglide

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.retrofituserprofileglide.api.AppCreator
import com.example.retrofituserprofileglide.api.models.ProfileResponse
import com.example.retrofituserprofileglide.utils.Status
import com.example.retrofituserprofileglide.viewmodels.ProfileViewModel
import com.example.retrofituserprofileglide.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var mProfileViewModel: ProfileViewModel
    private lateinit var mProfileResponse : ProfileResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        // no night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        // this code for statusbar just like instagram
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
        //...
        initData()
        obtainListFromServer()
    }
    private fun obtainListFromServer() {

        mProfileViewModel.getAllProfile().observe(this)


        {
            when(it.status){
                Status.SUCCESS -> {

                    mProfileResponse = it.data!!

                    getData()

                    Toast.makeText(
                        this,
                        "Sucessfully load the data",
                        Toast.LENGTH_LONG
                    ).show()

                }

                Status.FAILURE -> {
                    Toast.makeText(
                        this,
                        "Failed to load the data ${it.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                Status.LOADING -> {
                    Toast.makeText(
                        this,
                        "Loading...",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
    private fun getData() {

        val data  = mProfileResponse.getData()!!

        txt_username.text = data.getFirstName() + " "+ data.getLastName().toString()
        email.text = data.getEmail().toString()


        Glide.with(this@ProfileActivity).load(data.getAvatar()).apply(RequestOptions.circleCropTransform()).into(img_profile)


    }

    private fun initData() {
        //initialization of viewmodel instance,
        mProfileViewModel = ViewModelProvider(
            this,
            ViewModelFactory(AppCreator.getApiHelperInstance())
        ).get(ProfileViewModel::class.java)


    }
}
