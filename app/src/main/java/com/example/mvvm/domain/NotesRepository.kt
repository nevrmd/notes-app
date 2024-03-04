package com.example.mvvm.domain

import androidx.lifecycle.LiveData

interface NotesRepository {
    fun addNote(noteItem: NoteItem)

    fun deleteNote(noteItem: NoteItem)

    fun editNote(noteItem: NoteItem)

    fun getNoteByIdUseCase(noteId: Int): NoteItem

    fun getNotes(): LiveData<List<NoteItem>>
}