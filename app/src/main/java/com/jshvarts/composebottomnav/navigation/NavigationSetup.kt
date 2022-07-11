package com.jshvarts.composebottomnav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jshvarts.composebottomnav.screens.AboutScreen
import com.jshvarts.composebottomnav.screens.HomeScreen
import com.jshvarts.composebottomnav.screens.SettingsScreen

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(navController)
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen(navController)
        }
        /*composable(Screen.About.route) {
            AboutScreen(navController)
        }*/
        composable(Screen.About.withArgsFormat(Screen.About.id),
            arguments = listOf(navArgument(Screen.About.id){type = NavType.StringType})) { backStackEntry ->
            backStackEntry.arguments?.getString(Screen.About.id)?.let {
                AboutScreen(navController, backStackEntry.arguments?.getString(Screen.About.id)!!)
            }
        }
    }
}


