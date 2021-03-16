package com.tweetsearchbyivan.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tweetsearchbyivan.data.Datum

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Datum>?) {
    val adapter = recyclerView.adapter as TweetsListAdapter
    adapter.submitList(data)
}