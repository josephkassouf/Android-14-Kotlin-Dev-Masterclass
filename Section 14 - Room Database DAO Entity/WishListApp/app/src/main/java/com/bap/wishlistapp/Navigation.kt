package com.bap.wishlistapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.LongType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun Navigation(viewModel: WishViewModel = viewModel(), navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            HomeView(navController, viewModel)
        }
        composable(
            Screen.AddScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = LongType
                    defaultValue = 0L
                    nullable = false
                }
            )
        ) { entry ->
            val id = entry.arguments?.getLong("id") ?: 0L
            AddEditDetailView(id = id, viewModel = viewModel, navController = navController)
        }
    }
}