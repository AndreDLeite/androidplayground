package adl.appture.extensions

import java.time.format.DateTimeFormatter

fun String.isMercosulPlate(carPlate: String): Boolean {
    return Regex("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}").matches(carPlate)
}

fun String.isDayMonthYearTest(dateFormatter: String): Boolean {
    return Regex("(([0-2][0-9]|(3[0-1]))/(0[1-9]|1[1-2]))/([0-2][0-9]{3})").matches(dateFormatter)
}