package com.example.mvvm.presentation

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.domain.NoteItem

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteItemViewHolder>() {

    var notesList = listOf<NoteItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // how to create a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.note_recycler_view,
            parent,
            false
        )
        return NoteItemViewHolder(view)
    }

    // amount of items
    override fun getItemCount(): Int {
        return notesList.count()
    }

    // how to apply data on a view
    override fun onBindViewHolder(viewholder: NoteItemViewHolder, position: Int) {
        val noteItem = notesList[position]
        viewholder.tvTitle.text = noteItem.title
        viewholder.tvContent.text = noteItem.content
    }

    class NoteItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent: TextView = view.findViewById<TextView>(R.id.tvContent)
    }
}