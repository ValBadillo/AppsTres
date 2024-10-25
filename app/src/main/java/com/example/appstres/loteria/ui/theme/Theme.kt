package com.example.loto.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DarkBlue,        // Azul oscuro para el tema oscuro
    secondary = LightBeige,    // Beige claro para el secundario en tema oscuro
    tertiary = LightBeige      // Beige claro también para el terciario
)

private val LightColorScheme = lightColorScheme(
    primary = DarkBlue40,      // Azul oscuro más suave para el tema claro
    secondary = LightBeige40,  // Beige claro más oscuro para el secundario en tema claro
    tertiary = LightBeige40    // Beige claro más oscuro para el terciario

    /* Otros colores por defecto que puedes sobrescribir
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun LotoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color es disponible en Android 12+
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

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
