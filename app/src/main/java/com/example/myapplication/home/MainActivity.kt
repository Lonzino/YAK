package com.example.myapplication.home


import LandingScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myapplication.pages.FamillyList
import com.example.myapplication.pages.Home
import com.example.myapplication.pages.Myprofile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // Create a NavController
                val navController = rememberNavController()

                // Set up the NavHost with the start destination
                NavHost(
                    navController = navController as NavHostController,
                    startDestination = "LandingScreen",
                ) {
                    composable("LandingScreen") {
                        LandingScreen(
                            onTimeout = {
                                navController.navigate("Home")


                            }
                        )
                    }
                    composable("Home") { Home(navController) }

                    composable("FamillyList") { FamillyList(navController) }

                    composable("Myprofile") { Myprofile(navController) }

                }



            }

        }
    }
}




@Preview(showBackground = true)
@Composable
fun Preview() {
    AppTheme {
        LandingScreen(onTimeout = { })
    }
}





