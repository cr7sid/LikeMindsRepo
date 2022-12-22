package com.example.myapplication.Models

import com.google.gson.annotations.SerializedName

data class Meaning(
    @SerializedName("type") val type: String?,
    @SerializedName("definition") val definition: String?,
    @SerializedName("example") val example: String?,
    @SerializedName("image_url") val url: String?,
    @SerializedName("emoji") val emoji: String?)