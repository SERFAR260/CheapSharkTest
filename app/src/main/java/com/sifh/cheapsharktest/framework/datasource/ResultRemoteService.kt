package com.sifh.cheapsharktest.framework.datasource

import com.sifh.cheapsharktest.framework.data.Results
import retrofit2.http.GET

interface ResultRemoteService {
    @GET("https://www.cheapshark.com/api/1.0/deals?storeID=1&upperPrice=15")
    suspend fun listResults() : List<Results>
}