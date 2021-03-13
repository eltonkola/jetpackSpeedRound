/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.WeTradeTheme

sealed class AppScreens(val route: String) {
    object Welcome : AppScreens("welcome")
    object Login : AppScreens("login")
    object Home : AppScreens("home")
}

@ExperimentalMaterialApi
@Composable
fun MainAppScreen() {

    val navController = rememberNavController()
    NavHost(navController, startDestination = AppScreens.Welcome.route) {
        composable(AppScreens.Welcome.route) {
            WelcomeScreen {
                navController.navigate(AppScreens.Login.route)
            }
        }
        composable(AppScreens.Login.route) {
            LoginScreen {
                navController.navigate(AppScreens.Home.route)
            }
        }
        composable(AppScreens.Home.route) {
            HomeScreen()
        }
    }
}

@ExperimentalMaterialApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    WeTradeTheme {
        MainAppScreen()
    }
}

@ExperimentalMaterialApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    WeTradeTheme(darkTheme = true) {
        MainAppScreen()
    }
}
