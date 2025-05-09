package com.irvanmaulana0013.gudangku.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.irvanmaulana0013.gudangku.model.Barang
import kotlinx.coroutines.flow.Flow

@Dao
interface BarangDao {

    @Insert
    suspend fun insert(barang: Barang)

    @Update
    suspend fun update(barang: Barang)

    @Query("SELECT * FROM barang WHERE isDeleted = 0 ORDER BY tanggal DESC")
    fun getBarang(): Flow<List<Barang>>

    @Query("SELECT * FROM barang WHERE id = :id")
    suspend fun getBarangById(id: Long): Barang?

    @Query("DELETE FROM barang WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("UPDATE barang SET isDeleted = 1 WHERE id = :id")
    suspend fun moveToRecycleBinById(id: Long)

    @Query("UPDATE barang SET isDeleted = 0 WHERE id = :id")
    suspend fun restoreFromRecycleBinById(id: Long)

    @Query("SELECT * FROM barang WHERE isDeleted = 1 ORDER BY tanggal DESC")
    fun getDeletedBarang(): Flow<List<Barang>>
}