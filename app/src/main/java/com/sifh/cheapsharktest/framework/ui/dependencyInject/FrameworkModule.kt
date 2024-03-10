package com.sifh.cheapsharktest.framework.ui.dependencyInject

import com.sifh.cheapsharktest.data.datasource.RemoteDataSource
import com.sifh.cheapsharktest.framework.datasource.ResultRemoteService
import com.sifh.cheapsharktest.framework.datasource.ServerResultDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String = "https://www.cheapshark.com/"

    @Provides
    @Singleton
    fun retrofitProvider(@Named("baseUrl") baseUrl: String) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun resultRemoteServiceProvider(retrofit: Retrofit) : ResultRemoteService =
        retrofit.create(ResultRemoteService::class.java)

    @Provides
    fun remoteDataSourceProvider(resultRemoteService: ResultRemoteService) : RemoteDataSource {
        return ServerResultDataSource(resultRemoteService)
    }
}