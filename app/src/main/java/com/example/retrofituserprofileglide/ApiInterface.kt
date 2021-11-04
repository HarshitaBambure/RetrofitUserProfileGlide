package com.example.retrofituserprofileglide

import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/users/2")
    suspend fun getAllResult(): ProfileResponse
}