package com.mtjin.firebasemvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mtjin.firebasemvvm.R
import com.mtjin.firebasemvvm.data.Message
import com.mtjin.firebasemvvm.databinding.ItemMessageBinding

class MessageAdapter :
    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
    private val items: ArrayList<Message> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMessageBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_message,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].let {
            holder.bind(it)
        }
    }

    class ViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(message: Message) {
            binding.message = message
            binding.executePendingBindings()
        }
    }

    fun addItems(items: List<Message>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }
}