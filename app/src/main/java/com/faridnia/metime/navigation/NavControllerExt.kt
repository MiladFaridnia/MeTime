package com.faridnia.metime.navigation

import androidx.navigation.NavController
import com.faridnia.metime.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}