package com.example.Noteapp.dialog

import com.example.Noteapp.data.NoteItem

interface AddDialogListener {
    fun onAddButtonClicked(item: NoteItem)
}