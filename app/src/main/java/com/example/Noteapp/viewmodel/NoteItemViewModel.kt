package com.example.Noteapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.Noteapp.data.NoteItem
import com.example.Noteapp.repository.NoteItemRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class NoteItemViewModel(private val repository: NoteItemRepository) : ViewModel() {

    fun upsert(item: NoteItem) = GlobalScope.launch {
            repository.upsert(item)
    }

    fun delete(item: NoteItem) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllNotesListItems()

}