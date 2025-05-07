package com.irvanmaulana0013.gudangku.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irvanmaulana0013.gudangku.database.BarangDao
import com.irvanmaulana0013.gudangku.model.Barang
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: BarangDao) : ViewModel() {

    val data: StateFlow<List<Barang>> = dao.getBarang().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    fun getBarang(id: Long): Barang? {
        return data.value.find { it.id == id }
    }
}