import datetime.DateTimeUtil
import java.util.*

fun main(args: Array<String>) {
    println("========= Get Current Date By TimeZone =========")
    println(DateTimeUtil.getCurrentDateByTimeZone())

    println("========= Get Date Time To String =========")
    println(DateTimeUtil.getDateTimeToString(Date()))
    println(DateTimeUtil.getDateToString(Date()))
    println(DateTimeUtil.getTimeToString(Date()))

    println("========= Get Date Time From String =========")
    println(DateTimeUtil.getDateTimeFromString(DateTimeUtil.getDateTimeToString(Date())))
    println(DateTimeUtil.getDateFromString(DateTimeUtil.getDateToString(Date())))

    println("========= Get Date To Beginning or End of the Day =========")
    println(DateTimeUtil.getDateToBeginningOfDay(Date()))
    println(DateTimeUtil.getDateToEndOfDay(Date()))

    println("========= Get Date Range =========")
    DateTimeUtil.getDateRangeByNumberOfDays(Date(), 7).forEach { println(it) }
}