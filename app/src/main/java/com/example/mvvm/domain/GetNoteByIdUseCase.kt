package com.example.mvvm.domain

class GetNoteByIdUseCase(private val notesRepository: NotesRepository) {
    fun getNoteByIdUseCase(noteId: Int): NoteItem {
        return notesRepository.getNoteByIdUseCase(noteId)
    }
}