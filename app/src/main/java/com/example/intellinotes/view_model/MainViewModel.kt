package com.example.intellinotes.view_model

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intellinotes.dto.response.MaterialResponse
import com.example.intellinotes.service.MaterialService
import com.example.intellinotes.state.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

class MainViewModel(
    private val materialService: MaterialService
) : ViewModel() {
    private val _state = MutableStateFlow<MainState>(MainState.Empty)
    val state: StateFlow<MainState> = _state

    private val _expanded = MutableStateFlow(false)
    val expanded: StateFlow<Boolean> = _expanded

    private val _materials = MutableStateFlow(emptyList<MaterialResponse>())
    val materials: StateFlow<List<MaterialResponse>> = _materials

    private val _material = MutableStateFlow(null as MaterialResponse?)
    val material: StateFlow<MaterialResponse?> = _material

    private val _uri = MutableStateFlow(null as Uri?)
    val uri: StateFlow<Uri?> = _uri

    private val _id = MutableStateFlow("")
    val id: StateFlow<String> = _id

    fun getMaterials() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            val response = materialService.getMaterials()
            if (response.isSuccessful) {
                _materials.value = response.body()!!
                _state.value = MainState.Success
            } else {
                _state.value = MainState.Error(response.message())
                _materials.value = emptyList()
            }
        }
    }

    fun getMaterial(
        id: String
    ) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            val response = materialService.getMaterial(id)
            if (response.isSuccessful) {
                _material.value = response.body()!!
                _state.value = MainState.Success
            } else {
                _state.value = MainState.Error(response.message())
                _material.value = null
            }
        }
    }

    fun sendVoice(
        file: MultipartBody.Part
    ) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            val response = materialService.sendVoice(file)
            if (response.isSuccessful) {
                _materials.value = response.body()!!
                _state.value = MainState.Success
            } else {
                _state.value = MainState.Error(response.message())
                _materials.value = emptyList()
            }
        }
    }

    fun sendMock() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            val response = materialService.sendMock()
            if (response.isSuccessful) {
                _materials.value = response.body()!!
                _state.value = MainState.Success
            } else {
                _state.value = MainState.Error(response.message())
                _materials.value = emptyList()
            }
        }
    }

    fun sendText(
        file: MultipartBody.Part
    ) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            val response = materialService.sendText(file)
            if (response.isSuccessful) {
                _materials.value = response.body()!!
                _state.value = MainState.Success
            } else {
                _state.value = MainState.Error(response.message())
                _materials.value = emptyList()
            }
        }
    }

    fun setExpanded(newExpanded: Boolean) {
        _expanded.value = newExpanded
    }

    fun setId(newId: String) {
        _id.value = newId
    }
}