package email.example.praticaltest.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.TextUnit

@Composable
fun SuccessView(concatedStr: String) {
    Text(text = "Success. Result is ${concatedStr}")
}