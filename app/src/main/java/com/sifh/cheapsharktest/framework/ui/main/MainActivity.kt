package com.sifh.cheapsharktest.framework.ui.main

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import android.widget.Toast
import com.sifh.cheapsharktest.R
import com.sifh.cheapsharktest.data.repository.ResultRepository
import com.sifh.cheapsharktest.databinding.ActivityMainBinding
import com.sifh.cheapsharktest.framework.ui.common.isNetworkAvailable
import com.sifh.cheapsharktest.framework.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var resultRepository: ResultRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val resultAdapter = ResultAdapter()
        binding.recyclerGamesList.adapter = resultAdapter
        mainViewModel.results.observe(this) { resultsList ->
            resultAdapter.results = resultsList
        }
        if (isNetworkAvailable(this)) mainViewModel.onCreate()
        else Toast.makeText(this, R.string.noInternetAccess, Toast.LENGTH_LONG).show()
    }
}