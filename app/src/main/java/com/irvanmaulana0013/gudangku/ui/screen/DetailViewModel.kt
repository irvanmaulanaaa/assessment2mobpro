package com.irvanmaulana0013.gudangku.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irvanmaulana0013.gudangku.database.BarangDao
import com.irvanmaulana0013.gudangku.model.Barang
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: BarangDao): ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(nama: String, kategori: String, jumlah: String, deskripsi: String) {
        val barang = Barang(
            tanggal = formatter.format(Date()),
            nama = nama,
            kategori = kategori,
            jumlah = jumlah,
            deskripsi = deskripsi
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(barang)
        }
    }

    suspend fun getBarang(id: Long): Barang? {
        return dao.getBarangById(id)
    }

    fun update(id: Long, nama: String, kategori: String, jumlah: String, deskripsi: String) {
        val barang = Barang(
            id = id,
            tanggal = formatter.format(Date()),
            nama = nama,
            kategori = kategori,
            jumlah = jumlah,
            deskripsi = deskripsi
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(barang)
        }
    }

    fun moveToRecycleBin(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.moveToRecycleBinById(id)
        }
    }
}