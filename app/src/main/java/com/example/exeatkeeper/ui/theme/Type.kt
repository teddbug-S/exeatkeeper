package com.example.exeatkeeper.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.exeatkeeper.R


// Use the Google Fonts API to get the font files
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val defaultFont = FontFamily(
    Font(
        googleFont = GoogleFont("Quicksand"),
        fontProvider = provider,
    )
)

val brandFont = FontFamily(
    Font(
        googleFont = GoogleFont("Righteous"),
        fontProvider = provider,
    )
)


// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = defaultFont),
    displayMedium = baseline.displayMedium.copy(fontFamily = defaultFont),
    displaySmall = baseline.displaySmall.copy(fontFamily = defaultFont),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = brandFont),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = defaultFont),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = defaultFont),
    titleLarge = baseline.titleLarge.copy(fontFamily = defaultFont, fontSize = 32.sp),
    titleMedium = baseline.titleMedium.copy(fontFamily = defaultFont),
    titleSmall = baseline.titleSmall.copy(fontFamily = defaultFont),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = defaultFont),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = defaultFont),
    bodySmall = baseline.bodySmall.copy(fontFamily = defaultFont),
    labelLarge = baseline.labelLarge.copy(
        fontFamily = defaultFont,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold
    ),
    labelMedium = baseline.labelMedium.copy(fontFamily = defaultFont, fontSize = 14.sp),
    labelSmall = baseline.labelSmall.copy(fontFamily = defaultFont),
)

