package com.faridnia.metime.util

import android.content.res.Configuration
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true , backgroundColor = 0xFF35155D)
annotation class LightAndDarkPreview
