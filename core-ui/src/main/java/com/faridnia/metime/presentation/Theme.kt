package com.faridnia.metime.presentation

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF8F5F56), // A darker, vibrant shade of the primary color
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFFA86D60), // A complementary vibrant color
    tertiary = Color(0xFFCFAF9C), // Lighter than secondary, maintaining contrast
    onSurface = Color(0xFFFFFFFF), // White for high contrast on the dark surface
    onSurfaceVariant = Color(0xFFC8C8C8), // White for high contrast on the dark surface
    surface = Color(0xFF2A2A2A), // Darker surface color for depth
    background = Color(0xFF1A1A1A), // Even darker background color
    onBackground = Color(0xFFFFFFFF) // White for readability on the dark background
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFDCCC5),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFFD18E80),
    tertiary = Color(0xFFFFD9CC),
    onSurface = Color(0xFF333333),
    onSurfaceVariant = Color(0xFF7A7A7A),
    surface = Color(0xFFF7E6E0),
    background = Color(0xFFF2F2F2),
    onBackground = Color(0xFF333333)
)

@Composable
fun MeTimeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}