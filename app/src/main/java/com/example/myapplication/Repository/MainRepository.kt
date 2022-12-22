package com.example.myapplication.Repository

import com.example.myapplication.WordApi

class MainRepository(private val wordApi: WordApi) {
    suspend fun getAllMeanings(word: String) = wordApi.getMeanings("Token 78bb251553954d4c34a988e991e28ed8a6be322f", word)
}