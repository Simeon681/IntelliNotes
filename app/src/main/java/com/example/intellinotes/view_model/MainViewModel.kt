package com.example.intellinotes.view_model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel() : ViewModel() {
    private val _expanded = MutableStateFlow(false)
    val expanded: StateFlow<Boolean> = _expanded

    fun setExpanded(newExpanded: Boolean) {
        _expanded.value = newExpanded
    }
}