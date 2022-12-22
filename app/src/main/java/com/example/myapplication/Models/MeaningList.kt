package com.example.myapplication.Models

import com.google.gson.annotations.SerializedName

data class MeaningList(@SerializedName("definitions") val Meanings: MutableList<Meaning>)