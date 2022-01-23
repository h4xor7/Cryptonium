package com.pandey.cryptonium.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pandey.cryptonium.presentation.coin_detail.CoinDetailScreen
import com.pandey.cryptonium.presentation.coin_list.CoinListScreen
import com.pandey.cryptonium.presentation.ui.theme.CryptoniumTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoniumTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController =  rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route ){
                        composable(route= Screen.CoinListScreen.route){
                            CoinListScreen(navController =navController )
                        }

                        composable(route= Screen.CoinDetailScreen.route+"/{coinId}"){
                            CoinDetailScreen()

                        }
                    }



                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoniumTheme {
        Greeting("Android")
    }
}