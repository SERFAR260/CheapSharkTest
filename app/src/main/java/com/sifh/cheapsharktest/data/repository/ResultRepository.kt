package com.sifh.cheapsharktest.data.repository

import com.sifh.cheapsharktest.data.datasource.RemoteDataSource

class ResultRepository (private val remoteDataSource: RemoteDataSource) {
    suspend fun getResult() = remoteDataSource.getResults()
}