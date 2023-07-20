import domain.usecase.GetCurrencyRateUseCase
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val code = args.find {
        it.startsWith("--code=")
    }?.substringAfter("--code=")!!

    val date = args.find {
        it.startsWith("--date=")
    }?.substringAfter("--date=")!!

    val rate = GetCurrencyRateUseCase().invoke(code, date)

    if (rate != null) {
        println("${rate.code} (${rate.name}): ${rate.rate}")
        exitProcess(0)
    } else {
        println("Unexpected error occurred")
        exitProcess(-1)
    }
}