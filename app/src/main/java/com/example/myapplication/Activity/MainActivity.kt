package com.example.myapplication.Activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ViewModel.MeaningsViewModel
import com.example.myapplication.R
import com.example.myapplication.Adapters.ViewAdapter
import com.example.myapplication.Repository.MainRepository
import com.example.myapplication.ViewModel.MyViewModelFactory
import com.example.myapplication.WordApi

class MainActivity : AppCompatActivity() {
    private lateinit var input: EditText
    private lateinit var btn: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MeaningsViewModel
    private val meaningAdapter: ViewAdapter = ViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input = findViewById(R.id.user_input)
        btn = findViewById(R.id.fetch)
        recyclerView = findViewById(R.id.rv_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = meaningAdapter

        val retrofitClient = WordApi.getInstance()
        val mainRepository = MainRepository(retrofitClient)
        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MeaningsViewModel::class.java)
        btn.setOnClickListener {
            if (!input.text.isNullOrEmpty())
                viewModel.meaningsLiveData.observe(this, Observer {
                    meaningAdapter.addItems(it.Meanings)
                })
            viewModel.getMeanings(input.text.toString())
        }
    }
}