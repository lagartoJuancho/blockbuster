package com.jda.blockbuster.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jda.blockbuster.ui.screens.detail.DetailScreen
import com.jda.blockbuster.ui.screens.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavItem.Home.baseRoute) {
        composable(NavItem.Home) {
            HomeScreen(
                onItemClick = {
                    navController.navigate(NavItem.Detail.createRoute(it.id))
                }
            )
        }
        composable(NavItem.Detail) { backStackEntry ->
            DetailScreen(
                onBackPressed = { navController.popBackStack() },
                id = backStackEntry.findArg(NavArg.Id),
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}

inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.getString(arg.key)
    requireNotNull(value)
    return value as T
}


