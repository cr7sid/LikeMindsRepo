package com.example.myapplication.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Models.MeaningList
import com.example.myapplication.Repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MeaningsViewModel(private val mainRepository: MainRepository) : ViewModel() {
    val meaningsLiveData = MutableLiveData<MeaningList>()
    fun getMeanings(word: String) {
        CoroutineScope(Dispatchers.IO).launch {
            meaningsLiveData.postValue(mainRepository.getAllMeanings(word))
        }
    }
}