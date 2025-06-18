package com.ifts18.tpfinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifts18.tpfinal.R
import com.ifts18.tpfinal.models.QuickAccessItem

class QuickAccessAdapter(
    private val items: List<QuickAccessItem>,
    private val onItemClick: (QuickAccessItem) -> Unit
) : RecyclerView.Adapter<QuickAccessAdapter.QuickAccessViewHolder>() {

    inner class QuickAccessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivIcon: ImageView = itemView.findViewById(R.id.ivIcon)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvSubtitle: TextView = itemView.findViewById(R.id.tvSubtitle)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(items[position])
                }
            }
        }

        fun bind(item: QuickAccessItem) {
            ivIcon.setImageResource(item.iconRes)
            tvTitle.text = item.title
            tvSubtitle.text = item.subtitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuickAccessViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_quick_access, parent, false)
        return QuickAccessViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuickAccessViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}