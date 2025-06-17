package com.ifts18.tpfinal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.databinding.ItemQuickAccessBinding
import com.ifts18.tpfinal.models.QuickAccessItem

class QuickAccessAdapter(
    private val items: List<QuickAccessItem>,
    private val onItemClick: (QuickAccessItem) -> Unit
) : RecyclerView.Adapter<QuickAccessAdapter.QuickAccessViewHolder>() {

    inner class QuickAccessViewHolder(val binding: ItemQuickAccessBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(items[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuickAccessViewHolder {
        val binding = ItemQuickAccessBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return QuickAccessViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuickAccessViewHolder, position: Int) {
        val item = items[position]
        holder.binding.ivIcon.setImageResource(item.iconRes)
        holder.binding.tvTitle.text = item.title
        holder.binding.tvSubtitle.text = item.subtitle
    }

    override fun getItemCount() = items.size
}
