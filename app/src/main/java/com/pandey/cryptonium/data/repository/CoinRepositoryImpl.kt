package com.pandey.cryptonium.data.repository

import com.pandey.cryptonium.data.remote.CoinPaprikaApi
import com.pandey.cryptonium.data.remote.dto.CoinDetailDto
import com.pandey.cryptonium.data.remote.dto.CoinDto
import com.pandey.cryptonium.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
      return  api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
     return api.getCoinById(coinId)
    }
}