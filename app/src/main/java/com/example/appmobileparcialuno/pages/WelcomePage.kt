package com.example.appmobileparcialuno.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appmobileparcialuno.routes.Routes
import com.example.appmobileparcialuno.ui.theme.AppMobileParcialUnoTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomePage(
    navController : NavHostController,
    emailName: String
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerItem(
                    label = {
                            Text(text = "Cerrar Sesión")
                    },
                    selected = currentRoute== Routes.Page1.routes,
                    onClick = {
                        navController.navigate(Routes.Page1.routes)
                    },
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = "Welcome")
                    },
                    selected = currentRoute== Routes.Page2.routes,
                    onClick = {
                        navController.navigate(Routes.Page2.createRoute(emailName))
                        coroutineScope.launch {
                            drawerState.close()
                        }
                    },
                )
            }
        }
    ) {

        Scaffold(
            modifier = Modifier,
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Botón Menú"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("CAM - Claudio Alejandro Mathieu")
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { navController.navigate("login") }) {
                    Icon(Icons.Default.Close, contentDescription = "Cerrar Sesión")
                }
            }
        ){ innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bienvenido",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Hola Pedro",
                    fontSize = 24.sp
                )
                Text(
                    text = emailName,
                    fontSize = 24.sp
                )
            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun WelcomePagePreview() {
    val navHostController = rememberNavController()
    AppMobileParcialUnoTheme {
        WelcomePage(navHostController, "test@test.com")
    }
}