package com.aqube.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aqube.compose.ui.theme.lightGreen
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ProfileListScreen(userProfiles: List<UserProfile> = users) {
    Scaffold(topBar = { AppBar() }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(userProfiles) { user ->
                    ProfileCard(user)
                }
            }
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text(text = "Compose Demo", color = Color.White)
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Menu, "")
            }
        }
    )
}

@Composable
fun ProfileCard(userProfile: UserProfile) {
    Card(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile, 70.dp)
            ProfileContent(userProfile)
        }
    }
}

@Composable
fun ProfilePicture(userProfile: UserProfile, profilePicSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = if (userProfile.status)
                MaterialTheme.colors.lightGreen
            else Color.Red
        ),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = rememberCoilPainter(userProfile.pictureUrl),
            contentDescription = "",
            modifier = Modifier.size(profilePicSize),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(userProfile: UserProfile) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = userProfile.name, style = MaterialTheme.typography.h6)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = if (userProfile.status) "Active now" else "Offline",
                style = MaterialTheme.typography.body2
            )
        }
    }
}