package com.faridnia.metime.core.data.preferences

import android.content.SharedPreferences
import com.faridnia.metime.core.domain.preferences.Preferences
import com.faridnia.metime.core.domain.preferences.Preferences.Companion.SELECTED_MONTH

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
) : Preferences {

    override fun saveSelectedMonth(month: String) {
        sharedPreferences.edit().putString(SELECTED_MONTH, month).apply()
    }
}