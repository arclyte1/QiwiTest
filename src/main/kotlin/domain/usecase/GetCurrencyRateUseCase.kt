package domain.usecase

import data.remote.CurrencyRatesRepository
import domain.model.CurrencyRate
import kotlinx.coroutines.runBlocking

class GetCurrencyRateUseCase {

    private val repository: CurrencyRatesRepository = CurrencyRatesRepository.instance

    operator fun invoke(code: String, date: String): CurrencyRate? {
        return try {
            val formattedDate = date.split('-').reversed().joinToString("/")
            val rates = runBlocking { repository.getCurrencyRates(formattedDate) }
            rates.find { it.code == code }
        } catch (e: Exception) {
            // Something went wrong((
            null
        }
    }
}