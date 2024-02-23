package com.example.mvvm.domain

class GetNoteUseCase(private val notesRepository: NotesRepository) {
    fun getNote(): List<NoteItem> {
        return notesRepository.getNote()
    }
}