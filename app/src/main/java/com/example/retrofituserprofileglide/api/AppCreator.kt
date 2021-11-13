package com.example.retrofituserprofileglide.api

import android.app.Application
import com.example.retrofituserprofileglide.api.RetrofitClient.client

class AppCreator : Application() {
    companion object {

        private var mApiHelper: ApiHelper? = null
        fun getApiHelperInstance(): ApiHelper {
            if(mApiHelper ==null){
                mApiHelper = ApiHelper(client!!.create(ApiInterface::class.java))
            }
            return mApiHelper!!
        }

    }
}