package com.sifh.cheapsharktest.framework.ui.main

import com.sifh.cheapsharktest.data.repository.ResultRepository
import com.sifh.cheapsharktest.usecase.LoadResultsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainActivityModule {

    @Provides
    fun loadResultsProvider(repository: ResultRepository) : LoadResultsUseCase {
        return LoadResultsUseCase(repository)
    }
}
