package com.pandey.cryptonium.presentation.coin_detail

import com.pandey.cryptonium.common.Resource
import com.pandey.cryptonium.domain.model.Coin
import com.pandey.cryptonium.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? =null,
    val error:String = ""
)
