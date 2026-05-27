package com.example.counterapp.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

interface DataRepository {
  val count: StateFlow<Int>
  fun increment()
  fun decrement()
  fun reset()
}

class DefaultDataRepository : DataRepository {
  private val _count = MutableStateFlow(0)
  override val count: StateFlow<Int> = _count.asStateFlow()

  override fun increment() = _count.update { it + 1 }
  override fun decrement() = _count.update { it - 1 }
  override fun reset() = _count.update { 0 }
}
