package com.mtjin.firebasemvvm.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mtjin.firebasemvvm.data.Message


@BindingAdapter("setItems")
fun RecyclerView.setAdapterItems(items: List<Message>?) {
    with((adapter as MessageAdapter)) {
        if (items != null) {
            clear()
            addItems(items)
        }
    }
}


