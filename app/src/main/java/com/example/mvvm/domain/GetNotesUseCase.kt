package com.example.mvvm.domain

class GetNoteUseCase(private val notesRepository: NotesRepository) {
    fun getNotes(): List<NoteItem> {
        return notesRepository.getNotes()
    }
}