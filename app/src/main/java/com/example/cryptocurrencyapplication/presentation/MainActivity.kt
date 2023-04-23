package com.example.cryptocurrencyapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrencyapplication.presentation.coin_detail.CoinDetailScreen
//import com.example.cryptocurrencyapplication.presentation.coin_detail.CoinListScreen
import com.example.cryptocurrencyapplication.presentation.coin_list.CoinListScreen
import com.example.cryptocurrencyapplication.presentation.ui.theme.CryptoCurrencyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        setContent {
            CryptoCurrencyApplicationTheme{
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination =Screen.CoinListScreen.route
                    ){
                        composable(
                            route = Screen.CoinListScreen.route
                        ){
                            CoinListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ){
                            CoinDetailScreen()
                        }

                    }
                    
                }
            }
        }

    }


}