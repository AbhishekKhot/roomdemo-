package com.example.Noteapp.db


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.Noteapp.data.NoteItem

@Dao
interface NoteItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: NoteItem)

    @Delete
    suspend fun delete(item: NoteItem)

    @Query("SELECT * FROM notes_item")
    fun getAllShoppingItems(): LiveData<List<NoteItem>>
}