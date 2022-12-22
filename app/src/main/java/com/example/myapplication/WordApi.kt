package com.example.myapplication

import com.example.myapplication.Models.MeaningList
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface WordApi {
    @GET("dictionary/{word}")
    suspend fun getMeanings(@Header("Authorization") head: String, @Path("word") word: String): MeaningList
}