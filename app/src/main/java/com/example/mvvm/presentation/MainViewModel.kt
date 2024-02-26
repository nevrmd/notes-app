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

    // only get/edit/delete are required to work with screen
    private val getNotesUseCase = GetNoteUseCase(repository)
    private val editNoteUseCase = EditNoteUseCase(repository)
    private val deleteNoteUseCase = DeleteNoteUseCase(repository)

    val noteList = MutableLiveData<List<NoteItem>>()

    fun getNotes() {
        // gets elements from UseCase and adds them to LiveData
        val list = getNotesUseCase.getNotes()
        noteList.value = list // use postValue if not in main thread
    }
}