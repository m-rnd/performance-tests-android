package com.example.finews.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.entity.navigation.NavigationTarget
import com.example.finews.ui.screen.MainScreen
import com.example.interactor.Navigator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


// https://proandroiddev.com/jetpack-compose-navigation-architecture-with-viewmodels-1de467f19e1c

@Composable
fun NavigationComponent(
    navController: NavHostController,
    navigator: Navigator
) {
    LaunchedEffect("navigation") {
        navigator.sharedFlow.onEach {
            when (it) {
                is NavigationTarget.Up -> navController.navigateUp()
                else -> navController.navigate(it.name)
            }
        }.launchIn(this)
    }

    NavHost(
        navController = navController,
        startDestination = NavigationTarget.Main.name
    ) {
        composable(NavigationTarget.Main.name) {
            MainScreen(
                viewModel = hiltViewModel()
            )
        }
    }
}