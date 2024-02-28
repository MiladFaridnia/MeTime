package com.faridnia.metime.core.domain.preferences

interface Preferences {

    companion object {
        const val SELECTED_MONTH = "month"
    }

    fun saveSelectedMonth(month: String)
}