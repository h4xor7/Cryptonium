package com.pandey.cryptonium.presentation.coin_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pandey.cryptonium.common.Constants
import com.pandey.cryptonium.common.Resource
import com.pandey.cryptonium.domain.use_case.get_coin.GetCoinUseCase
import com.pandey.cryptonium.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private  val getCoinUseCase: GetCoinUseCase,
     val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<CoinDetailState>(CoinDetailState())
    val state = _state

    init {
       savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
           getCoin(coinId)
       }
    }

    private fun getCoin(coinId:String){
        getCoinUseCase(coinId = coinId).onEach { result ->
           when(result){

               is Resource.Success ->{
                   _state.value = CoinDetailState(coin = result.data )

               }

               is Resource.Error ->{
                   _state.value = CoinDetailState(error = result.message ?: "An unexpected error occured")

               }

               is Resource.Loading ->{
                   _state.value = CoinDetailState(isLoading = true)
               }

           }
       }.launchIn(viewModelScope)
    }

}