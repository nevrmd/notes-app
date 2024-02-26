package com.example.mvvm.domain

data class NoteItem(
    val title: String,
    val content: String,
    var id: Int = UNDEFINED_ID,
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
