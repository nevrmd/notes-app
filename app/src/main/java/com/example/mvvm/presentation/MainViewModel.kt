package com.example.mvvm.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.NotesRepositoryImplementation
import com.example.mvvm.domain.DeleteNoteUseCase
import com.example.mvvm.domain.EditNoteUseCase
import com.example.mvvm.domain.GetNoteUseCase
import com.example.mvvm.domain.NoteItem

class MainViewModel: ViewModel() {

    private val repository = NotesRepositoryImplementation

    // only get/delete are required to work with user in MainActivity
    private val getNotesUseCase = GetNoteUseCase(repository)
    private val deleteNoteUseCase = DeleteNoteUseCase(repository)

    val noteList = getNotesUseCase.getNotes()

    fun deleteNote(noteItem: NoteItem) {
        // deletes note
        deleteNoteUseCase.deleteNote(noteItem)
        // and adds changes to LiveData
    }
}