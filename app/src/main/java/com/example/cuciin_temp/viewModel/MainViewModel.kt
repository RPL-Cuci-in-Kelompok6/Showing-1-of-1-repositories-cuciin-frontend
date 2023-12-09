package com.example.cuciin_temp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cuciin_temp.model.MitraX
import com.example.cuciin_temp.model.Services
import com.example.cuciin_temp.network.ApiService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var MitraXListResponse:List<MitraX> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    // MutableState to hold the services
//    private val _servicesState: MutableState<Services> = mutableStateOf(services)
//    val servicesState: MutableState<Services>
//        get() = _servicesState
//
//    // Getter for services
//    val services: Services
//        get() = _servicesState.value
//
//    // Setter for services
//    fun setServices(newServices: Services) {
//        _servicesState.value = newServices
//    }

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