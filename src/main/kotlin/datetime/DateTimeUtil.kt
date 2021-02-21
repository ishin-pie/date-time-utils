package datetime

import java.text.SimpleDateFormat
import java.text.DateFormat
import java.text.ParseException
import java.util.*


class DateTimeUtil {

    companion object {

        private const val DEFAULT_TIMEZONE : String = "Asia/Phnom_Penh"
        private const val DATE_TIME_PATTERN : String = "yyyy-MMM-dd HH:mm:ss"
        private const val DATE_PATTERN : String = "yyyy-MMM-dd"
        private const val TIME_PATTERN : String = "HH:mm:ss"

        fun getCurrentDateByTimeZone(timeZone: String = DEFAULT_TIMEZONE): Date? {
            val dateFormat = SimpleDateFormat(DATE_TIME_PATTERN)
            val dateFormatConf = SimpleDateFormat(DATE_TIME_PATTERN)
            dateFormatConf.timeZone = TimeZone.getTimeZone(timeZone)
            val date = Date()
            return try {
                dateFormat.parse(dateFormatConf.format(date))
            } catch (exception: ParseException) {
                println("Unable to get TimeZone $exception")
                date
            }
        }

        fun getDateTimeToString(date: Date?): String? {
            val formatter: DateFormat = SimpleDateFormat(DATE_TIME_PATTERN)
            return formatter.format(date)
        }

        fun getDateToString(date: Date?): String? {
            val formatter: DateFormat = SimpleDateFormat(DATE_PATTERN)
            return formatter.format(date)
        }

        fun getTimeToString(date: Date?): String? {
            val formatter: DateFormat = SimpleDateFormat(TIME_PATTERN)
            return formatter.format(date)
        }

        fun getDateTimeFromString(dateString: String?): Date? {
            val formatter = SimpleDateFormat(DATE_TIME_PATTERN)
            return try {
                formatter.parse(dateString)
            } catch (exception: ParseException) {
                println("Unable to get date using string date $exception")
                null
            }
        }

        fun getDateFromString(dateString: String?): Date? {
            val formatter = SimpleDateFormat(DATE_PATTERN)
            return try {
                formatter.parse(dateString)
            } catch (exception: ParseException) {
                println("Unable to get date using string date $exception")
                null
            }
        }

        fun getDateToBeginningOfDay(date: Date?): Date? {
            val cal = Calendar.getInstance()
            cal.time = date
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            return cal.time
        }

        fun getDateToEndOfDay(date: Date?): Date? {
            val cal = Calendar.getInstance()
            cal.time = date
            cal.set(Calendar.HOUR_OF_DAY, 23)
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND, 999);
            return cal.time
        }

        fun getDateRangeByNumberOfDays(date: Date?, numberOfDays: Int): Array<Date?>{
            val dates: Array<Date?> = arrayOfNulls(2)
            val cal = Calendar.getInstance()
            cal.time = date
            dates[0] = cal.time
            cal.add(Calendar.DAY_OF_YEAR, numberOfDays)
            dates[1] = cal.time
            return dates
        }
    }
}