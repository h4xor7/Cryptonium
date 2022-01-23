package com.pandey.cryptonium.domain.use_case.get_coin

import com.pandey.cryptonium.common.Resource
import com.pandey.cryptonium.data.remote.dto.toCoin
import com.pandey.cryptonium.data.remote.dto.toCoinDetailDto
import com.pandey.cryptonium.domain.model.Coin
import com.pandey.cryptonium.domain.model.CoinDetail
import com.pandey.cryptonium.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator  fun invoke(coinId:String):Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin= repository.getCoinById(coinId = coinId).toCoinDetailDto()
            emit(Resource.Success<CoinDetail>(coin))
        }
        catch (e:HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        }
        catch (e:IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server.Check your internet connection"))

        }
    }
}