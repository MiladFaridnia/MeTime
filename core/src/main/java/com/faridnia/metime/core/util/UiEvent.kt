package com.faridnia.metime.core.util

sealed class UiEvent {
    data class Navigate(val route: String) : UiEvent()
    data object NavigateUp : UiEvent()
}