package com.example.parcial3_gabriel_campos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddReaction
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.EmergencyRecording
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
    navController: NavController,
    onOpenPhotoGallery: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tarjeta para Ver Fotos y Videos
        HomeScreenCard(
            title = "Ver Fotos y Videos",
            description = "Explora tus fotos y videos en la galería",
            icon = Icons.Default.AddReaction,
            backgroundColor = Color(0xFF0D47A1), // Azul intenso
            onClick = { onOpenPhotoGallery() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tarjeta para Tomar Foto
        HomeScreenCard(
            title = "Tomar Foto",
            description = "Captura momentos especiales",
            icon = Icons.Default.CameraAlt,
            backgroundColor = Color(0xFFF9A825), // Amarillo intenso
            onClick = { navController.navigate("photo") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tarjeta para Grabar Video
        HomeScreenCard(
            title = "Grabar Video",
            description = "Documenta tus experiencias en video",
            icon = Icons.Default.EmergencyRecording,
            backgroundColor = Color(0xFFB71C1C), // Rojo intenso
            onClick = { navController.navigate("video") }
        )
    }
}

@Composable
fun HomeScreenCard(
    title: String,
    description: String,
    icon: ImageVector,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(4.dp), // Padding fuera de la tarjeta para la sombra
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor // Color de fondo fuerte de la tarjeta
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Sombra para realce visual
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            // Fondo redondeado para el ícono
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.White, shape = RoundedCornerShape(50)) // Fondo blanco redondeado para el ícono
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = backgroundColor, // Tint del ícono igual al color de fondo
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Título y descripción de la tarjeta
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White, // Texto en blanco para resaltar
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.8f), // Descripción en blanco suave
                    fontSize = 14.sp
                )
            }
        }
    }
}