package com.aqube.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val greetingListState = remember { mutableStateListOf<String>("John", "Chris", "Andrew") }
    var newNameState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingList(greetingListState,
            { greetingListState.add(newNameState.value) },
            newNameState.value,
            { newNameState.value = it }
        )
    }
}

@Composable
fun GreetingList(
    namesList: List<String>,
    buttonClick: () -> Unit,
    textFieldValue: String,
    textFieldChange: (name: String) -> Unit
) {
    namesList.forEach { name ->
        Text(text = name, style = MaterialTheme.typography.h4)
    }


    TextField(value = textFieldValue, onValueChange = textFieldChange)

    Button(onClick = { buttonClick.invoke() }) {
        Text(text = "Add name")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}