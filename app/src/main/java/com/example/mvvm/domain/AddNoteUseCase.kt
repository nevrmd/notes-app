package com.example.mvvm.domain

class AddNoteUseCase(private val notesRepository: NotesRepository) {
    fun addNote(noteItem: NoteItem) {
        notesRepository.addNote(noteItem)
    }
}