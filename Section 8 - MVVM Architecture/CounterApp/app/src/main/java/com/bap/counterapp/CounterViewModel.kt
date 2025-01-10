package com.bap.counterapp

import androidx.compose.runtime.MutableState

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _repository: CounterRepository = CounterRepository()
    private val _count = mutableStateOf(_repository.getCounter().count)

    // Public mutable state for external access
    val count: MutableState<Int> get() = _count

    // Function to increment the counter
    fun increment() {
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    // Function to decrement the counter
    fun decrement() {
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}