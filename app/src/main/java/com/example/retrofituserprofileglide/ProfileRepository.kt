package com.example.retrofituserprofileglide

class ProfileRepository (private val apiHelper: ApiHelper) {

    suspend fun getUserProfile() = apiHelper.getAllResult()

}