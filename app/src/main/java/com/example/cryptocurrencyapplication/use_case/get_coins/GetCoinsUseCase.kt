package com.example.cryptocurrencyapplication.use_case.get_coins

import com.example.cryptocurrencyapplication.common.Resource
import com.example.cryptocurrencyapplication.data.remote.dto.toCoin
import com.example.cryptocurrencyapplication.domain.model.Coin
import com.example.cryptocurrencyapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))

        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?: "Error!!!"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldnt reach server check your internet connection"))
        }
    }
}