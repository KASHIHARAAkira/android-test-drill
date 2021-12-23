package email.example.praticaltest.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import email.example.praticaltest.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {
    sealed class UiState {
        object Initial: UiState()

        object Loading: UiState()

        data class Success(val concatedStr: String): UiState()

        object Error: UiState()
    }

    val uiState: MutableState<UiState> = mutableStateOf(UiState.Initial)

    fun concatStrLoad(str1: String, str2: String){
        viewModelScope.launch {
            uiState.value = UiState.Loading
            kotlin.runCatching {
                userRepository.concatStr(str1 = str1, str2 = str2)
            }.onSuccess { result ->
                uiState.value = UiState.Success(concatedStr = result)
            }.onFailure {
                uiState.value = UiState.Error
            }
        }
    }
}