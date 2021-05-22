package com.aqube.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun UsersApplication(userList: List<UserProfile> = com.aqube.compose.userList) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "userList") {
        composable(route = "userList") {
            ProfileListScreen(userList,navController)
        }
        composable(route = "userDetails") {
            ProfileDetailsScreen(userList[0])
        }
    }
}