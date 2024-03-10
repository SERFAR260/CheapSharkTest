package com.sifh.cheapsharktest.data.datasource

import com.sifh.cheapsharktest.domain.Result
interface RemoteDataSource {
    suspend fun getResults() : List<Result>
}