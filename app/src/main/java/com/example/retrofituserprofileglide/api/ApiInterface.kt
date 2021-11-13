package com.example.retrofituserprofileglide.api

import com.example.retrofituserprofileglide.api.models.ProfileResponse
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/users/2")
    suspend fun getAllResult(): ProfileResponse
}