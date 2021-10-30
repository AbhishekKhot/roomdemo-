package com.example.Noteapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.Noteapp.R
import com.example.Noteapp.data.NoteItem
import com.example.Noteapp.viewmodel.NoteItemViewModel
import kotlinx.android.synthetic.main.rv_item.view.*


class NoteItemAdapter(
    var noteItemsList: List<NoteItem>,
    private val viewModel: NoteItemViewModel,
) : RecyclerView.Adapter<NoteItemAdapter.NoteItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        return NoteItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent, false))
    }

    override fun getItemCount(): Int {
        return noteItemsList.size
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        holder.itemView.tvItemName.text = noteItemsList[position].name
        holder.itemView.tvItemAmount.text = "${noteItemsList[position].amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(noteItemsList[position])
        }

        holder.itemView.ivItemPlus.setOnClickListener {
            noteItemsList[position].amount++
            viewModel.upsert(noteItemsList[position])
        }

        holder.itemView.ivItemMinus.setOnClickListener {
            if (noteItemsList[position].amount > 0) {
                noteItemsList[position].amount--
                viewModel.upsert(noteItemsList[position])
            }
        }
    }

    inner class NoteItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}