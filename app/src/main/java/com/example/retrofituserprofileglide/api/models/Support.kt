package com.example.retrofituserprofileglide.api.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Support {
    @SerializedName("url")
    @Expose
    private var url: String? = null

    @SerializedName("text")
    @Expose
    private var text: String? = null

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }

    fun getText(): String? {
        return text
    }

    fun setText(text: String?) {
        this.text = text
    }

}