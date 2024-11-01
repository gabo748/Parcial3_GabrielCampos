package com.example.parcial3_gabriel_campos.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddReaction
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.EmergencyRecording
import androidx.compose.ui.graphics.vector.ImageVector

data class OnBoardingPage(
    val title: String,
    val description: String,
    val icon: ImageVector // Recurso drawable para cada ícono
)

val onboardingPages = listOf(
    OnBoardingPage(
        title = "Bienvenido a GabCam",
        description = "Captura momentos especiales fácilmente",
        icon = Icons.Default.CameraAlt // Cambia por un ícono real
    ),
    OnBoardingPage(
        title = "Graba tus videos",
        description = "Documenta tus experiencias en video",
        icon = Icons.Default.EmergencyRecording // Cambia por un ícono real
    ),
    OnBoardingPage(
        title = "Explora la galería",
        description = "Visualiza tus fotos y videos guardados",
        icon = Icons.Default.AddReaction // Cambia por un ícono real
    )
)
