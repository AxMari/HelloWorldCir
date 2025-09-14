package com.example.helloworldcir.ui.theme // Ensure this matches your package path

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

// --- Light Color Scheme ---
// It uses the 'val's you defined in your Color.kt file
private val AppLightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,

    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,

    tertiary = LightTertiary,
    onTertiary = LightOnTertiary,
    tertiaryContainer = LightTertiaryContainer,
    onTertiaryContainer = LightOnTertiaryContainer,

    error = LightError,
    onError = LightOnError,
    errorContainer = LightErrorContainer,
    onErrorContainer = LightOnErrorContainer,

    background = LightBackground,
    onBackground = LightOnBackground,

    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,

    outline = LightOutline
    // You can also define inverseSurface, inverseOnSurface, inversePrimary, surfaceTint, scrim
)

// --- Dark Color Scheme ---
// It uses the 'val's you defined in your Color.kt file
private val AppDarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,

    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = DarkOnSecondaryContainer,

    tertiary = DarkTertiary,
    onTertiary = DarkOnTertiary,
    tertiaryContainer = DarkTertiaryContainer,
    onTertiaryContainer = DarkOnTertiaryContainer,

    error = DarkError,
    onError = DarkOnError,
    errorContainer = DarkErrorContainer,
    onErrorContainer = DarkOnErrorContainer,

    background = DarkBackground,
    onBackground = DarkOnBackground,

    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,

    outline = DarkOutline
    // You can also define inverseSurface, inverseOnSurface, inversePrimary, surfaceTint, scrim
)

// --- Your Main Theme Composable ---
@Composable
fun HelloWorldTheme( // You can rename this to YourAppNameTheme or AppTheme if you prefer
    useDarkTheme: Boolean = isSystemInDarkTheme(), // Detects system dark mode setting
    // dynamicColor: Boolean = true, // For Material You dynamic theming on Android 12+ (optional)
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        // dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> { // For dynamic color
        //    val context = LocalContext.current
        //    if (useDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        // } // If you add dynamic color, you'll need to handle the 'Build' import for commonMain (e.g., via expect/actual)
        useDarkTheme -> AppDarkColorScheme
        else -> AppLightColorScheme
    }

    // If you create Typography.kt and Shapes.kt, you'll pass them here too
    MaterialTheme(
        colorScheme = colorScheme,
        // typography = AppTypography, // Example: Assuming AppTypography is defined in Type.kt
        // shapes = AppShapes,       // Example: Assuming AppShapes is defined in Shape.kt
        content = content
    )
}
