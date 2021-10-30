package com.example.Noteapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.Noteapp.repository.NoteItemRepository


@Suppress("UNCHECKED_CAST")
class NoteItemViewModelFactory(private val repository: NoteItemRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteItemViewModel(repository) as T
    }
}