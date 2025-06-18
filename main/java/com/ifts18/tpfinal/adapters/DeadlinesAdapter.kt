package com.ifts18.tpfinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.R
import com.ifts18.tpfinal.models.DeadlineItem

class DeadlinesAdapter(private val items: List<DeadlineItem>) :
    RecyclerView.Adapter<DeadlinesAdapter.DeadlineViewHolder>() {

    inner class DeadlineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvDate: TextView = itemView.findViewById(R.id.tvDate)

        fun bind(item: DeadlineItem) {
            tvTitle.text = item.title
            tvDate.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeadlineViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_deadline, parent, false)
        return DeadlineViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeadlineViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
