package com.example.cuciin_temp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cuciin_temp.model.DataX
import com.example.cuciin_temp.model.DataXXX
import com.example.cuciin_temp.model.Layanan
import com.example.cuciin_temp.model.Mesin
import com.example.cuciin_temp.model.MitraX
import com.example.cuciin_temp.model.Pesanan
import com.example.cuciin_temp.model.ServicesResponses
import com.example.cuciin_temp.network.ApiService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var MitraXListResponse: List<MitraX> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")


    fun getMitraX() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val mitraXList = apiService.getMitra()
                MitraXListResponse = mitraXList.data.mitra
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    var customerEmail: String by mutableStateOf("")
    var customerId: Int by mutableStateOf(0)
    lateinit var selectedMitra: DataX
    lateinit var selectedLayanan: Layanan
    lateinit var selectedMesin: Mesin
    var listOrder: List<Pesanan> = emptyList()


}