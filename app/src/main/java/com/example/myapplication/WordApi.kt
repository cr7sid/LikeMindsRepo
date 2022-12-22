package com.example.myapplication

import com.example.myapplication.Models.MeaningList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface WordApi {
    @GET("dictionary/{word}")
    suspend fun getMeanings(@Header("Authorization") head: String, @Path("word") word: String): MeaningList
    companion object {
        var retrofitService: WordApi? = null
        fun getInstance(): WordApi {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://owlbot.info/api/v4/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(WordApi::class.java)
            }
            return retrofitService!!
        }

    }
}