package com.example.mvvm.data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.domain.NotesRepository
import com.example.mvvm.domain.NoteItem
import java.lang.RuntimeException

object NotesRepositoryImplementation : NotesRepository {

    private val notesLD = MutableLiveData<List<NoteItem>>()
    private val notesList = mutableListOf<NoteItem>()
    private var autoIncrementId = 0
    override fun addNote(noteItem: NoteItem) {
        // if id is undefined then add it
        // else: don't
        // called because id would change while calling editNote
        if (noteItem.id == NoteItem.UNDEFINED_ID) {
            noteItem.id = autoIncrementId++
        }
        notesList.add(noteItem)
        updateList()
    }

    override fun deleteNote(noteItem: NoteItem) {
        notesList.remove(noteItem)
        updateList()
    }

    override fun editNote(noteItem: NoteItem) {
        // removes note and places a new one defined on the top
        val oldElement = getNoteByIdUseCase(noteItem.id)
        notesList.remove(oldElement)
        notesList.add(noteItem)
    }
    override fun getNoteByIdUseCase(noteId: Int): NoteItem {
        return notesList.find {
            it.id == noteId
        } ?:throw RuntimeException("Element $noteId not found")
    }

    override fun getNotes(): LiveData<List<NoteItem>> {
        return notesLD
    }

    private fun updateList() {
        notesLD.value = notesList.toList()
    }

}