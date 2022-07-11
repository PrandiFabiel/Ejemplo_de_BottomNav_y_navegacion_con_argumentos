package com.jshvarts.composebottomnav.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Settings : Screen("settings_screen")
    object About : Screen("about_screen"){
        val id = "id"
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }

    fun withArgsFormat(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/{$arg}")
            }
        }
    }
}