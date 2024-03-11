package com.example.mvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.domain.NoteItem

private lateinit var vm: ViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.noteList.observe(this) {
            adapter.notesList = it
        }
    }

    private fun setupRecyclerView() {
        val rvNotes = findViewById<RecyclerView>(R.id.rvNotes)
        adapter = NotesAdapter()
        rvNotes.adapter = adapter
    }
}