package com.example.myapplication.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Models.Meaning
import com.example.myapplication.R

class ViewAdapter : RecyclerView.Adapter<ViewAdapter.ViewHolder>() {

    private var meanings: MutableList<Meaning> = mutableListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mType: TextView = view.findViewById(R.id.word_type)
        val mDef: TextView = view.findViewById(R.id.word_def)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meaning: Meaning = meanings[position]
        holder.mType.text = meaning.type;
        holder.mDef.text = meaning.definition;
    }

    fun addItems(list: MutableList<Meaning>?) {
        if (list != null) {
            this.meanings.clear()
            this.meanings.addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return meanings.size
    }

}