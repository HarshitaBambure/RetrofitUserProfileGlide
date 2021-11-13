package com.example.retrofituserprofileglide.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofituserprofileglide.api.ApiHelper
import com.example.retrofituserprofileglide.repository.ProfileRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProfileViewModel::class.java)){
            return ProfileViewModel(ProfileRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Class not found")
    }
}