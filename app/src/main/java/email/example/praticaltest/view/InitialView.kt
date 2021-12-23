package email.example.praticaltest.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import email.example.praticaltest.view_model.MainViewModel

@Composable
fun InitialView(mainViewModel: MainViewModel) {
    var str1 by remember{ mutableStateOf("") }
    var str2 by remember{ mutableStateOf("") }
    Column {
        TextField(value = str1, onValueChange = { str1 = it })
        TextField(value = str2, onValueChange = { str2 = it })
        Button(onClick = { mainViewModel.concatStrLoad(str1 = str1, str2 = str2) }) {
            Text(text = "Send")
        }
    }
}