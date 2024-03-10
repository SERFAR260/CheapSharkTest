package com.sifh.cheapsharktest.usecase

import com.sifh.cheapsharktest.data.repository.ResultRepository
import com.sifh.cheapsharktest.domain.Result

class LoadResultsUseCase(private val repository: ResultRepository) {

    suspend fun invoke() : List<Result> = repository.getResult()
}