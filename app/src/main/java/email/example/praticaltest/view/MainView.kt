package email.example.praticaltest.view

import android.app.Activity
import android.content.Context
import androidx.annotation.NonNull
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import email.example.praticaltest.view_model.MainViewModel

@Composable
fun MainView(mainViewModel: MainViewModel) {
    val uiState: MainViewModel.UiState by mainViewModel.uiState
    
    when(uiState) {
        is MainViewModel.UiState.Initial -> {
            InitialView(mainViewModel = mainViewModel)
        }
        is MainViewModel.UiState.Loading -> {
            LoadingView()
        }
        is MainViewModel.UiState.Success -> {
            SuccessView(concatedStr = uiState.requireConcatedStr())
        }
        is MainViewModel.UiState.Error -> {
            ErrorView()
        }
    }
}

private fun MainViewModel.UiState.requireConcatedStr(): String {
    if(this !is MainViewModel.UiState.Success) throw IllegalAccessException("Not success")
    return concatedStr
}