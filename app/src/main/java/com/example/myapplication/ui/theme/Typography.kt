package com.example.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

// Set of Material typography styles to start with

val cafe24ssurround = FontFamily(
    Font(R.font.cafe24ssurround, FontWeight.Normal),
)
private val light = Font(R.font.cafe24ssurround, FontWeight.W300)
private val regular = Font(R.font.cafe24ssurround, FontWeight.W400)
private val medium = Font(R.font.cafe24ssurround, FontWeight.W500)
private val semibold = Font(R.font.cafe24ssurround, FontWeight.W600)

private val cafe24ssurroundFontFamily = FontFamily(fonts = listOf(light, regular, medium, semibold))

val appTypography = Typography(

    displayLarge = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W300,
        fontSize = 96.sp
    ),
    displayMedium = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 60.sp
    ),
    displaySmall = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 48.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 34.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp
    ),
    titleLarge = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    titleMedium = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    titleSmall = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = cafe24ssurroundFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)