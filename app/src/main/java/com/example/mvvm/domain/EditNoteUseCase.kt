package com.example.mvvm.domain

class EditNoteUseCase(private val notesRepository: NotesRepository) {
    fun editNote(noteItem: NoteItem) {
        notesRepository.editNote(noteItem)
    }
}