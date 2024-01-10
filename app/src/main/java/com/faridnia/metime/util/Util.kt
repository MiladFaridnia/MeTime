package com.faridnia.metime.util

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
    val timeFormat = SimpleDateFormat("hh:mm a",Locale.getDefault())
    return timeFormat.format(date)
}