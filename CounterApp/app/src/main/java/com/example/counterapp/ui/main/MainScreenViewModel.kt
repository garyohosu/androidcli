package com.example.counterapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.counterapp.data.DataRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainScreenViewModel(private val repository: DataRepository) : ViewModel() {
  val uiState: StateFlow<MainScreenUiState> =
    repository.count
      .map { MainScreenUiState.Success(it) }
      .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), MainScreenUiState.Success(0))

  fun increment() = repository.increment()
  fun decrement() = repository.decrement()
  fun reset() = repository.reset()
}

sealed interface MainScreenUiState {
  data class Success(val count: Int) : MainScreenUiState
}
