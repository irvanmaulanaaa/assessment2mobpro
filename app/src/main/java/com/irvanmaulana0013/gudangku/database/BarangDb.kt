package com.irvanmaulana0013.gudangku.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.irvanmaulana0013.gudangku.model.Barang

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE barang ADD COLUMN isDeleted INTEGER NOT NULL DEFAULT 0")
    }
}

@Database(entities = [Barang::class], version = 2, exportSchema = false)
abstract class BarangDb : RoomDatabase() {

    abstract val dao: BarangDao

    companion object {

        @Volatile
        private var INSTANCE: BarangDb? = null

        fun getInstance(context: Context): BarangDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BarangDb::class.java,
                        "barang.db"
                    )
                        .addMigrations(MIGRATION_1_2)
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}