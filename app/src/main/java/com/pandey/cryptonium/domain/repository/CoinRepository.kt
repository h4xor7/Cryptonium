package com.pandey.cryptonium.domain.repository

import com.pandey.cryptonium.data.remote.dto.CoinDetailDto
import com.pandey.cryptonium.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun  getCoins():List<CoinDto>

    suspend fun  getCoinById(coinId:String):CoinDetailDto
}