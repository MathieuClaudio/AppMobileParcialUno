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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appmobileparcialuno.ui.theme.AppMobileParcialUnoTheme

@Composable
fun MainPage(modifier: Modifier = Modifier) {

    val navHostController = rememberNavController()
//    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route

        MainNavHost(modifier, navHostController)
}


@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navHostController : NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = "login"
    ) {
        composable("login") { LoginPage(navHostController) }
        composable("welcome") { WelcomePage(navHostController) }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AppMobileParcialUnoTheme {
        MainPage()
    }
}