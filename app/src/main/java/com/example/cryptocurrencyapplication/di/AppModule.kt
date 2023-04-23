package com.example.cryptocurrencyapplication.di

import com.example.cryptocurrencyapplication.common.Constants
import com.example.cryptocurrencyapplication.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyapplication.data.repository.CoinRepositoryImpl
import com.example.cryptocurrencyapplication.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api : CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }

}