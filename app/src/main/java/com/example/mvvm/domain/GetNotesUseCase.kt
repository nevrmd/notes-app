package com.example.mvvm.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GetNoteUseCase(private val notesRepository: NotesRepository) {
    fun getNotes(): LiveData<List<NoteItem>> {
        return notesRepository.getNotes()
    }
}