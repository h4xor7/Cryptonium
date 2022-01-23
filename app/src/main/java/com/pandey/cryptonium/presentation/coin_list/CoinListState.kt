package com.pandey.cryptonium.presentation.coin_list

import com.pandey.cryptonium.common.Resource
import com.pandey.cryptonium.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error:String = ""
)
