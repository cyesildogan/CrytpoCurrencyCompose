package com.example.cryptocurrencyapplication.presentation.coin_list

import com.example.cryptocurrencyapplication.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean= false,
    val coins: List<Coin> = emptyList(),
    val error: String= ""
)
