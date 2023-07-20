package data.remote

import data.remote.dto.CurrencyRatesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyRateApi {

    @GET("scripts/XML_daily.asp")
    suspend fun getRates(
        @Query("date_req") date: String
    ) : CurrencyRatesResponse
}