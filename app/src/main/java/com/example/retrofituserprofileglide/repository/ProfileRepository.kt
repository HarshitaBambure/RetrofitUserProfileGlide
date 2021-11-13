package com.example.retrofituserprofileglide.repository

import com.example.retrofituserprofileglide.api.ApiHelper

class ProfileRepository (private val apiHelper: ApiHelper) {

    suspend fun getUserProfile() = apiHelper.getAllResult()

}