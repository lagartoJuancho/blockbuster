package com.jda.blockbuster.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    val baseRoute: String,
    private val navArgs: List<NavArg> = emptyList()
) {
    object Home : NavItem("home")
    object Detail : NavItem(
        "detail",
        listOf(NavArg.Id)
    ) {
        fun createRoute(id: String): String {
            return "$baseRoute/$id"
        }
    }

    val route = run {
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }
}

enum class NavArg(val key: String, val navType: NavType<*>) {
    Id("id", NavType.StringType),
}