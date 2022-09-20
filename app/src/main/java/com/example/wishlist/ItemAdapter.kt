package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: List<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemNameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

    init{
        itemNameTextView = itemView.findViewById(R.id.itemNameTextView)
        priceTextView = itemView.findViewById(R.id.priceTextView)
        urlTextView = itemView.findViewById(R.id.urlTextView)
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        // should get them from the edit text input

        val item = items.get(position)
        holder.itemNameTextView.text = item.name
        holder.priceTextView.text = item.price
        holder.urlTextView.text = item.url
    }

    override fun getItemCount(): Int {
        return items.size
    }
}