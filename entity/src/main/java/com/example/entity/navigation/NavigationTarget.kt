package com.example.entity.navigation

sealed class NavigationTarget(open val name: String) {
    object Up : NavigationTarget("up")
    object Main : NavigationTarget("main")
}