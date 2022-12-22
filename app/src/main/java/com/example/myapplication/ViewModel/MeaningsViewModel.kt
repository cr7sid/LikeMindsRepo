package com.example.myapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Models.MeaningList
import com.example.myapplication.WordApi
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MeaningsViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder().baseUrl("https://owlbot.info/api/v4/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val service = retrofit.create(WordApi::class.java)
    fun getMeanings(word: String): LiveData<MeaningList> {
        val liveData = MutableLiveData<MeaningList>()
        viewModelScope.launch {
            try {
                val meanings =
                    service.getMeanings("Token 78bb251553954d4c34a988e991e28ed8a6be322f", word)
                liveData.postValue(meanings)
            } catch (e: Exception) {

            }
        }
        return liveData
    }
}