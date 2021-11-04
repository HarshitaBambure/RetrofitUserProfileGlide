package com.example.retrofituserprofileglide

class ApiHelper (private val apiInterface: ApiInterface) {
    suspend fun getAllResult() = apiInterface.getAllResult()
}