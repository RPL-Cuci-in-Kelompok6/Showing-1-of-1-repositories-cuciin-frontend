package com.example.cuciin_temp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cuciin_temp.model.MitraX
import com.example.cuciin_temp.network.ApiService
import kotlinx.coroutines.launch

class MitraViewModel : ViewModel() {

    var MitraXListResponse:List<MitraX> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getMitraX() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val mitraXList = apiService.getMitra()
                MitraXListResponse = mitraXList.data.mitra
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }


}