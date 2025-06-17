package com.ifts18.tpfinal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.databinding.ItemDeadlineBinding
import com.ifts18.tpfinal.models.DeadlineItem

class DeadlinesAdapter(private val items: List<DeadlineItem>) :
    RecyclerView.Adapter<DeadlinesAdapter.DeadlineViewHolder>() {

    inner class DeadlineViewHolder(private val binding: ItemDeadlineBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DeadlineItem) {
            binding.tvTitle.text = item.title
            binding.tvDate.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeadlineViewHolder {
        val binding = ItemDeadlineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeadlineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeadlineViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
