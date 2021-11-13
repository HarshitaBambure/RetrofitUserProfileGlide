package com.example.retrofituserprofileglide.api

class ApiHelper (private val apiInterface: ApiInterface) {
    suspend fun getAllResult() = apiInterface.getAllResult()
}