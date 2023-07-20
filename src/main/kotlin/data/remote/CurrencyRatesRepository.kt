package data.remote

import domain.model.CurrencyRate
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class CurrencyRatesRepository private constructor() {

    private val api = Retrofit.Builder()
        .baseUrl("https://www.cbr.ru/")
        .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy())))
        .build()
        .create(CurrencyRateApi::class.java)


    suspend fun getCurrencyRates(date: String) = api.getRates(date).rates.map {
        CurrencyRate(
            code = it.code,
            name = it.name,
            rate = (it.value.replace(',', '.').toDouble() /
                    (it.nominal.replace(',', '.').toDouble()))
                .toString().replace('.', ',')
        )
    }

    companion object {
        val instance by lazy { CurrencyRatesRepository() }
    }
}