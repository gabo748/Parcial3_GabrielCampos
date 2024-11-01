package com.example.parcial3_gabriel_campos.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.parcial3_gabriel_campos.model.OnBoardingPage
import com.example.parcial3_gabriel_campos.model.onboardingPages

@Composable
fun OnBoardingScreen(navController: NavController) {
    val currentPageIndex = remember { mutableStateOf(0) }
    val currentPage = onboardingPages[currentPageIndex.value]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Contenido de la página actual de OnBoarding, centrado verticalmente
        OnBoardingPageContent(
            onBoardingPage = currentPage,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
                .fillMaxWidth()
                .background(Color(0xFFF1F3F4), shape = RoundedCornerShape(16.dp))
                .padding(32.dp)
        )

        // Botones de navegación en la parte inferior de la pantalla, centrados
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp) // Separación desde el borde inferior
        ) {
            if (currentPageIndex.value > 0) {
                Button(
                    onClick = { currentPageIndex.value -= 1 },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF6200EE), // Color de fondo personalizado
                        contentColor = Color.White // Color del texto
                    ),
                    shape = RoundedCornerShape(50), // Botón redondeado
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp), // Sombra
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Anterior")
                }

                Spacer(modifier = Modifier.width(16.dp))
            }

            Button(
                onClick = {
                    if (currentPageIndex.value < onboardingPages.size - 1) {
                        currentPageIndex.value += 1
                    } else {
                        navController.navigate("home") // Navega a la pantalla de inicio al finalizar el OnBoarding
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE), // Color de fondo personalizado
                    contentColor = Color.White // Color del texto
                ),
                shape = RoundedCornerShape(50), // Botón redondeado
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp), // Sombra
                modifier = Modifier.weight(1f)
            ) {
                Text(if (currentPageIndex.value < onboardingPages.size - 1) "Siguiente" else "Empezar")
            }
        }
    }
}

@Composable
fun OnBoardingPageContent(onBoardingPage: OnBoardingPage, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Fondo circular para el ícono con sombra
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(80.dp)
                .background(Color(0xFF6200EE), shape = CircleShape)
                .padding(16.dp)
                .graphicsLayer {
                    shadowElevation = 8.dp.toPx() // Sombra en el ícono
                    shape = CircleShape
                    clip = true
                }
        ) {
            Icon(
                imageVector = onBoardingPage.icon,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        // Texto con estilo de título
        Text(
            text = onBoardingPage.title,
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp),
            color = Color(0xFF333333)
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Texto de descripción
        Text(
            text = onBoardingPage.description,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF666666),
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}