package com.karakoca.baseproject.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val md_theme_light_primary = Color(0xFF00658B)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFC5E7FF)
val md_theme_light_onPrimaryContainer = Color(0xFF001E2D)
val md_theme_light_secondary = Color(0xFF00668A)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFC3E8FF)
val md_theme_light_onSecondaryContainer = Color(0xFF001E2C)
val md_theme_light_tertiary = Color(0xFF1560A5)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFD3E4FF)
val md_theme_light_onTertiaryContainer = Color(0xFF001C38)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFBFCFF)
val md_theme_light_onBackground = Color(0xFF191C1E)
val md_theme_light_surface = Color(0xFFFBFCFF)
val md_theme_light_onSurface = Color(0xFF191C1E)
val md_theme_light_surfaceVariant = Color(0xFFDDE3EA)
val md_theme_light_onSurfaceVariant = Color(0xFF41484D)
val md_theme_light_outline = Color(0xFF71787E)
val md_theme_light_inverseOnSurface = Color(0xFFF0F1F3)
val md_theme_light_inverseSurface = Color(0xFF2E3133)
val md_theme_light_inversePrimary = Color(0xFF7ED0FF)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFFFBFCFF)
val md_theme_light_outlineVariant = Color(0xFFC1C7CD)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFF7ED0FF)
val md_theme_dark_onPrimary = Color(0xFF00344A)
val md_theme_dark_primaryContainer = Color(0xFF004C6A)
val md_theme_dark_onPrimaryContainer = Color(0xFFC5E7FF)
val md_theme_dark_secondary = Color(0xFF7AD0FF)
val md_theme_dark_onSecondary = Color(0xFF003549)
val md_theme_dark_secondaryContainer = Color(0xFF004C68)
val md_theme_dark_onSecondaryContainer = Color(0xFFC3E8FF)
val md_theme_dark_tertiary = Color(0xFFA2C9FF)
val md_theme_dark_onTertiary = Color(0xFF00315C)
val md_theme_dark_tertiaryContainer = Color(0xFF004881)
val md_theme_dark_onTertiaryContainer = Color(0xFFD3E4FF)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF191C1E)
val md_theme_dark_onBackground = Color(0xFFE1E2E5)
val md_theme_dark_surface = Color(0xFF191C1E)
val md_theme_dark_onSurface = Color(0xFFE1E2E5)
val md_theme_dark_surfaceVariant = Color(0xFF41484D)
val md_theme_dark_onSurfaceVariant = Color(0xFFC1C7CD)
val md_theme_dark_outline = Color(0xFF8B9297)
val md_theme_dark_inverseOnSurface = Color(0xFF191C1E)
val md_theme_dark_inverseSurface = Color(0xFFE1E2E5)
val md_theme_dark_inversePrimary = Color(0xFF00658B)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFF191C1E)
val md_theme_dark_outlineVariant = Color(0xFF41484D)
val md_theme_dark_scrim = Color(0xFF000000)


val MaterialTheme.textFieldBackground: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Unspecified else colorScheme.tertiaryContainer.copy(
        alpha = 0.4f
    )
/*
val md_theme_light_primary = Color(0xFF3453CC)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFDDE1FF)
val md_theme_light_onPrimaryContainer = Color(0xFF001355)
val md_theme_light_secondary = Color(0xFF5A5D72)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFDFE1F9)
val md_theme_light_onSecondaryContainer = Color(0xFF171B2C)
val md_theme_light_tertiary = Color(0xFF3453CC)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFDDE1FF)
val md_theme_light_onTertiaryContainer = Color(0xFF001355)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFEFBFF)
val md_theme_light_onBackground = Color(0xFF1B1B1F)
val md_theme_light_surface = Color(0xFFFEFBFF)
val md_theme_light_onSurface = Color(0xFF1B1B1F)
val md_theme_light_surfaceVariant = Color(0xFFE2E1EC)
val md_theme_light_onSurfaceVariant = Color(0xFF45464F)
val md_theme_light_outline = Color(0xFF767680)
val md_theme_light_inverseOnSurface = Color(0xFFF3F0F4)
val md_theme_light_inverseSurface = Color(0xFF303034)
val md_theme_light_inversePrimary = Color(0xFFB8C3FF)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFFFBFCFF)
val md_theme_light_outlineVariant = Color(0xFFC6C5D0)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFB8C3FF)
val md_theme_dark_onPrimary = Color(0xFF002388)
val md_theme_dark_primaryContainer = Color(0xFF1238B3)
val md_theme_dark_onPrimaryContainer = Color(0xFFDDE1FF)
val md_theme_dark_secondary = Color(0xFFC3C5DD)
val md_theme_dark_onSecondary = Color(0xFF2C2F42)
val md_theme_dark_secondaryContainer = Color(0xFF424659)
val md_theme_dark_onSecondaryContainer = Color(0xFFDFE1F9)
val md_theme_dark_tertiary = Color(0xFFB8C3FF)
val md_theme_dark_onTertiary = Color(0xFF002388)
val md_theme_dark_tertiaryContainer = Color(0xFF1238B3)
val md_theme_dark_onTertiaryContainer = Color(0xFFDDE1FF)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF1B1B1F)
val md_theme_dark_onBackground = Color(0xFFE4E1E6)
val md_theme_dark_surface = Color(0xFF1B1B1F)
val md_theme_dark_onSurface = Color(0xFFE4E1E6)
val md_theme_dark_surfaceVariant = Color(0xFF45464F)
val md_theme_dark_onSurfaceVariant = Color(0xFFC6C5D0)
val md_theme_dark_outline = Color(0xFF90909A)
val md_theme_dark_inverseOnSurface = Color(0xFF1B1B1F)
val md_theme_dark_inverseSurface = Color(0xFFE4E1E6)
val md_theme_dark_inversePrimary = Color(0xFF3453CC)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFB8C3FF)
val md_theme_dark_outlineVariant = Color(0xFF45464F)
val md_theme_dark_scrim = Color(0xFF000000)

 */

