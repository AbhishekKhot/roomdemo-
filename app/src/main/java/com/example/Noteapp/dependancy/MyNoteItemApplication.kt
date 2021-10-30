package com.example.Noteapp.dependancy

import android.app.Application
import com.example.Noteapp.db.NoteItemDatabase
import com.example.Noteapp.repository.NoteItemRepository
import com.example.Noteapp.viewmodel.NoteItemViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyNoteItemApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MyNoteItemApplication))
        bind() from singleton { NoteItemDatabase(instance()) }
        bind() from singleton { NoteItemRepository(instance()) }
        bind() from provider { NoteItemViewModelFactory(instance()) }
    }
}