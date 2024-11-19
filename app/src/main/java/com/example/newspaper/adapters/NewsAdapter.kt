package com.example.newspaper.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newspaper.databinding.ItemNewsPaperBinding
import com.example.newspaper.network.Article

class NewsAdapter : ListAdapter<Article, NewsAdapter.ItemViewHolder>(NewsDiffCallback()) {

    // Define a click listener as a lambda
    private var onItemClickListener: ((Article) -> Unit)? = null

    // Method to set the click listener from outside the adapter
    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

    // ViewHolder class
    inner class ItemViewHolder(private val binding: ItemNewsPaperBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Article) {
            Glide.with(this.itemView).load(item.urlToImage).into(binding.imgNews)
            binding.tvNewsTitle.text = item.title
            binding.tvDescription.text = item.description
            binding.tvPublishedAt.text = item.publishedAt
            binding.tvSource.text = item.source.name

            // Set click listener on root view or any view you want to trigger the click event
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(item)
            }
        }
    }

    // DiffUtil class for efficient item comparison
    class NewsDiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflate view using ViewBinding
        val binding = ItemNewsPaperBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
