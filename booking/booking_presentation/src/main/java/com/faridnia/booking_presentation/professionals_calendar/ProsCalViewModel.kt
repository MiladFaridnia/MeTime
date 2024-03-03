package com.faridnia.booking_presentation.professionals_calendar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.faridnia.metime.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProsCalViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    var selectedMonth by mutableStateOf("")
    private set

}