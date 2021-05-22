package com.aqube.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aqube.compose.ui.theme.JetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeTheme {
                ProfileListScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileListPreview() {
    JetpackcomposeTheme {
        ProfileListScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileDetailPreview() {
    JetpackcomposeTheme {
        ProfileDetailsScreen()
    }
}