package com.mtjin.firebasemvvm.ui

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mtjin.firebasemvvm.data.Message


@BindingAdapter("setItems")
fun RecyclerView.setAdapterItems(items: List<Message>?) {
    with((adapter as MessageAdapter)) {
        Log.d("FFFFSetItems", items.toString())
        if (items != null) {
            this.clear()
            this.addItems(items)
        }
//        this.clear()
//        items?.let { this.addItems(it) }
    }
}


