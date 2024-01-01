package com.faridnia.metime.util

import java.util.Calendar
import java.util.Date

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}