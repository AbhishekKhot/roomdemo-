package com.example.Noteapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Noteapp.*
import com.example.Noteapp.adapter.NoteItemAdapter
import com.example.Noteapp.db.NoteItemDatabase
import com.example.Noteapp.dialog.AddDialogListener
import com.example.Noteapp.dialog.AddNoteItemDialog
import com.example.Noteapp.data.NoteItem
import com.example.Noteapp.repository.NoteItemRepository
import com.example.Noteapp.viewmodel.NoteItemViewModel
import com.example.Noteapp.viewmodel.NoteItemViewModelFactory
import kotlinx.android.synthetic.main.activity_note_item.*

class NoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_item)

        val database = NoteItemDatabase(this)
        val repository = NoteItemRepository(database)
        val viewModelFactory = NoteItemViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(NoteItemViewModel::class.java)

        val adapter = NoteItemAdapter(listOf(), viewModel)
        rvNotesItems.layoutManager = LinearLayoutManager(this)
        rvNotesItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.noteItemsList = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddNoteItemDialog(this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: NoteItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
    }
}