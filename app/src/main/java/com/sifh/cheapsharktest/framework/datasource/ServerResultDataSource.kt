package com.sifh.cheapsharktest.framework.datasource

import com.sifh.cheapsharktest.data.datasource.RemoteDataSource
import com.sifh.cheapsharktest.domain.Result

class ServerResultDataSource(private val resultRemoteService: ResultRemoteService) : RemoteDataSource {
    override suspend fun getResults(): List<Result> {
        val mResult = resultRemoteService.listResults()
        return mResult.map {
            result -> Result(
                result.gameID, result.title, result.salePrice, result.steamRatingText
            )
        }
    }
}