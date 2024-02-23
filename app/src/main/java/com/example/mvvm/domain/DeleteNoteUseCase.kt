package com.example.mvvm.domain

class DeleteNoteUseCase(private val notesRepository: NotesRepository) {
    fun deleteNote(noteItem: NoteItem) {
        notesRepository.deleteNote(noteItem)
    }
}