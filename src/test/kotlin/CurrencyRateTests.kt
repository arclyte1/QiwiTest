import domain.usecase.GetCurrencyRateUseCase
import org.junit.Test

class CurrencyRateTests {

    private val getCurrencyRateUseCase = GetCurrencyRateUseCase()

    @Test
    fun `Get currency rate with valid arguments`() {
        val rate = getCurrencyRateUseCase(code = "USD", date = "2022-10-08")
        assert(rate != null)
        assert(rate?.code == "USD")
        assert(rate?.name == "Доллар США")
        assert(rate?.rate == "61,2475")
    }

    @Test
    fun `Get currency rate with invalid currency code`() {
        val rate = getCurrencyRateUseCase(code = "something@#$5", date = "2022-10-08")
        assert(rate == null)
    }

    @Test
    fun `Get currency rate with invalid date`() {
        val rate = getCurrencyRateUseCase(code = "USD", date = "9999-10-08")
        assert(rate == null)
    }
}