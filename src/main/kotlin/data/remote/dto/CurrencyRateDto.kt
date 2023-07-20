package data.remote.dto

import org.simpleframework.xml.Element

data class CurrencyRateDto(
    @field:Element(name = "CharCode", required = false)
    var code: String = "",

    @field:Element(name = "Nominal", required = false)
    var nominal: String = "",

    @field:Element(name = "Name", required = false)
    var name: String = "",

    @field:Element(name = "Value", required = false)
    var value: String = "",
)
