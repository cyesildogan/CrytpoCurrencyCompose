package com.example.cryptocurrencyapplication.domain.repository

import com.example.cryptocurrencyapplication.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyapplication.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}