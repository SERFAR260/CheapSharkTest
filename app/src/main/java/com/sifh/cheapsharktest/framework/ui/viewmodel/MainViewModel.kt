package com.sifh.cheapsharktest.framework.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sifh.cheapsharktest.usecase.LoadResultsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import com.sifh.cheapsharktest.domain.Result
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(private val loadResultsUseCase: LoadResultsUseCase) :
    ViewModel() {
    private val job = Job()
    private val _results = MutableLiveData<List<Result>>()
    val results: LiveData<List<Result>> get() = _results

    fun onCreate() {
        viewModelScope.launch (Dispatchers.Main){
            _results.value = loadResultsUseCase.invoke()
        }
    }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}