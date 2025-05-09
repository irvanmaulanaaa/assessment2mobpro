package com.irvanmaulana0013.gudangku.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barang")
data class Barang(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val kategori: String,
    val jumlah: String,
    val deskripsi: String,
    val tanggal: String,
    val isDeleted: Boolean = false
)
