package com.example.appmobileparcialuno.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appmobileparcialuno.ui.theme.AppMobileParcialUnoTheme

@Composable
fun MainPage(modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "CAM", fontSize = 70.sp, fontWeight = FontWeight.Bold)
        Text(text = "Inicia con tu cuenta")
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (email == "pedro@pe.com.ar" && password == "abc123") {
                    // Acceso exitoso
                    errorMessage = ""
                    // Aquí puedes navegar a la siguiente pantalla o realizar otra acción
                } else {
                    // Datos incorrectos
                    errorMessage = "Ingresaste datos incorrectos"
                }
            }
        ) {
            Text("Ingresar")
        }

        if (errorMessage.isNotEmpty()) {
            Text(errorMessage)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AppMobileParcialUnoTheme {
        MainPage()
    }
}