package com.example.retrofituserprofileglide

import android.app.Application
import com.example.retrofituserprofileglide.RetrofitClient.client

class AppCreator : Application() {
    companion object {

        private var mApiHelper:ApiHelper? = null
        fun getApiHelperInstance():ApiHelper{
            if(mApiHelper==null){
                mApiHelper = ApiHelper(client!!.create(ApiInterface::class.java))
            }
            return mApiHelper!!
        }

    }
}