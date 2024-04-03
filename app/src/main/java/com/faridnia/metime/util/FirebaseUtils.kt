package com.faridnia.metime.util

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.logEvent

class FirebaseUtils {

    fun logScreenView(firebaseAnalytics: FirebaseAnalytics, screenTitle: String) {
        firebaseAnalytics.logEvent(screenTitle) {
            param(
                FirebaseAnalytics.Param.SCREEN_NAME,
                screenTitle
            )
        }
    }
}