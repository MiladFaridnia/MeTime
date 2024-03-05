package com.faridnia.metime

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}

/*
* Sample output "19 \n Tue"
*/
fun formatDateToDayAndDayOfWeekInTwoLines(date: Date): String {
    val dayFormat = SimpleDateFormat("d", Locale.getDefault())
    val dayOfWeekFormat = SimpleDateFormat("E", Locale.getDefault())

    val day = dayFormat.format(date)
    val dayOfWeek = dayOfWeekFormat.format(date)

    return "$day \n $dayOfWeek"
}

/*
* Sample output "10:30 AM"
*/
fun formatTimeToHourInDay(date: Date): String {
    val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    return timeFormat.format(date)
}

/*
* Sample output "Tuesday, 19 04:30pm"
*/
fun formatTimeToDayInWeek(date: Date): String {
    val outputDateFormat = SimpleDateFormat("EEEE, d    hh:mma", Locale.ENGLISH)
    return outputDateFormat.format(date)
}

fun getCurrentDay(): Int {
    return Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
}

fun getCurrentMonth(): Int {
    return Calendar.getInstance().get(Calendar.MONTH)
}

fun getCurrentYer(): Int {
    return Calendar.getInstance().get(Calendar.YEAR)
}

fun getCurrentMonthName(): String {
    return when (getCurrentMonth()) {
        1 -> "Jan"
        2 -> "Feb"
        3 -> "Mar"
        4 -> "Apr"
        5 -> "May"
        6 -> "Jun"
        7 -> "Jul"
        8 -> "Aug"
        9 -> "Sep"
        10 -> "Oct"
        11 -> "Nov"
        12 -> "Dec"
        else -> ""
    }
}