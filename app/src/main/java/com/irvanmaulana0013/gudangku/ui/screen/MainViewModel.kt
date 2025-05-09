package com.irvanmaulana0013.gudangku.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irvanmaulana0013.gudangku.database.BarangDao
import com.irvanmaulana0013.gudangku.model.Barang
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(private val dao: BarangDao) : ViewModel() {

    val data: StateFlow<List<Barang>> = dao.getBarang().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    val deleteData: StateFlow<List<Barang>> = dao.getDeletedBarang().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    fun undoDeleted(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.restoreFromRecycleBinById(id)
        }
    }

    fun deletePermanent(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}