package com.tweetsearchbyivan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tweetsearchbyivan.data.Datum
import com.tweetsearchbyivan.databinding.SingleItemBinding

class TweetsListAdapter(val onClickListener: OnClickListener) : ListAdapter<Datum, TweetsListAdapter.DatumViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Datum>() {
        override fun areItemsTheSame(oldItem: Datum, newItem: Datum): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Datum, newItem: Datum): Boolean {
            return oldItem.text == newItem.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatumViewHolder {
        return DatumViewHolder(SingleItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DatumViewHolder, position: Int) {
        val singleTweet = getItem(position)
        holder.bind(singleTweet)
    }

    class DatumViewHolder(private var binding: SingleItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tweet: Datum) {
            binding.tweet = tweet
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (data: Datum) -> Unit) {
        fun onClick(data:Datum) = clickListener(data)
    }

}