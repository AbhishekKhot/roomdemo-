package com.example.Noteapp.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.Noteapp.data.NoteItem

@Database(
    entities = [NoteItem::class],
    version = 1
)
abstract class NoteItemDatabase: RoomDatabase() {

    abstract fun getNoteItemDao(): NoteItemDao

    companion object {
        @Volatile
        private var instance: NoteItemDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
                instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                NoteItemDatabase::class.java, "NoteItemDB.db").build()
    }
}