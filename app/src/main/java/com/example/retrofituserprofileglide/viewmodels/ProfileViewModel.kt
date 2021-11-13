package com.example.retrofituserprofileglide.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.retrofituserprofileglide.api.models.Resource
import com.example.retrofituserprofileglide.repository.ProfileRepository

class ProfileViewModel(private val mProfileRepository: ProfileRepository) : ViewModel(){

    fun getAllProfile() = liveData {
        emit(Resource.loading(null))
        try{
            emit(Resource.success(mProfileRepository.getUserProfile()))
        } catch (e:Exception){
            emit(Resource.error(null, e.message.toString()))
        }
    }

}