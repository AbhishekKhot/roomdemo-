package com.example.Noteapp.repository

import com.example.Noteapp.db.NoteItemDatabase
import com.example.Noteapp.data.NoteItem

class NoteItemRepository(private val db: NoteItemDatabase) {

    suspend fun upsert(item: NoteItem) = db.getNoteItemDao().upsert(item)

    suspend fun delete(item: NoteItem) = db.getNoteItemDao().delete(item)

    fun getAllNotesListItems() = db.getNoteItemDao().getAllShoppingItems()
}