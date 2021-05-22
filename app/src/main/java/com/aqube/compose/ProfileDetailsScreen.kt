package com.aqube.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ProfileDetailsScreen(userId: Int, navController: NavHostController?) {
    val user = userList.first { user ->
        user.id == userId
    }

    Scaffold(topBar = {
        AppBar(
            title = "User Details",
            imageVector = Icons.Filled.ArrowBack
        ) {
            navController?.navigateUp()
        }
    }) {


        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfilePicture(user, 200.dp)
                ProfileContent(user, Alignment.CenterHorizontally)
            }
        }
    }
}
