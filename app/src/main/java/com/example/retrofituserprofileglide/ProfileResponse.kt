package com.example.retrofituserprofileglide

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class ProfileResponse {
    @SerializedName("data")
    @Expose
    private var data: Data? = null

    @SerializedName("support")
    @Expose
    private var support: Support? = null

    fun getData(): Data? {
        return data
    }

    fun setData(data: Data?) {
        this.data = data
    }

    fun getSupport(): Support? {
        return support
    }

    fun setSupport(support: Support?) {
        this.support = support
    }
}