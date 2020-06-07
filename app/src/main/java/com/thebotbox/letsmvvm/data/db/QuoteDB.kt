package com.thebotbox.letsmvvm.data.db

import android.content.Context
import android.os.Environment
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thebotbox.letsmvvm.data.db.dao.QuoteDao
import com.thebotbox.letsmvvm.data.db.entity.QuoteEntity

private const val PRIVATE_DATABASE_NAME = "quotes.db"

private val PUBLIC_DATABASE_NAME =
    Environment.getExternalStorageDirectory()
        .toString() + "/quotes.db"

@Database(
    entities = [QuoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class QuoteDB : RoomDatabase() {
    abstract fun dao(): QuoteDao

    companion object {
        @Volatile
        private var instance: QuoteDB? = null
        private val LOCK: Any = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDataBase(context).also { instance = it }
        }

        private fun createDataBase(context: Context): QuoteDB =
            Room.databaseBuilder(
                context.applicationContext,
                QuoteDB::class.java,
                PRIVATE_DATABASE_NAME
            ).build()

    }
}