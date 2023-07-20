package data.remote.dto

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ValCurs", strict = false)
data class CurrencyRatesResponse(
    @field:ElementList(entry = "Valute", required = true, inline = true)
    var rates: List<CurrencyRateDto> = mutableListOf()
)
