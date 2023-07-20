import domain.usecase.GetCurrencyRateUseCase
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val code = args.find {
        it.startsWith("--code=")
    }?.substringAfter("--code=")

    val date = args.find {
        it.startsWith("--date=")
    }?.substringAfter("--date=")

    if (code == null || date == null) {
        println("Arguments --code=XXX and --date=YYYY-MM-DD required")
        exitProcess(-1)
    } else {

        val rate = GetCurrencyRateUseCase().invoke(code, date)

        if (rate != null) {
            println("${rate.code} (${rate.name}): ${rate.rate}")
            exitProcess(0)
        } else {
            println("Unexpected error occurred")
            exitProcess(-1)
        }
    }
}