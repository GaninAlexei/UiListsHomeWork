package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.homework.uilistshomework.databinding.CardViewBinding
import com.homework.uilistshomework.databinding.ItemHeaderBinding
import com.homework.uilistshomework.databinding.ItemMovieBinding


class MoviesAdapter(private val listener: IMovieClick) : ListAdapter<Item, BaseViewHolder>(MoviesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            MOVIE_ITEM_TYPE -> MovieViewHolder(parent)
            HEADER_ITEM_TYPE -> HeaderViewHolder(parent)
            else -> WatchedMoviesViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is Item.Movie -> (holder as MovieViewHolder).bind(item)
            is Item.Header -> (holder as HeaderViewHolder).bind(item)
            is Item.WatchedMovie -> (holder as WatchedMoviesViewHolder).bind(item)
        }

    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Item.Movie -> MOVIE_ITEM_TYPE
            is Item.Header -> HEADER_ITEM_TYPE
            is Item.WatchedMovie -> WATCHED_ITEM_TYPE
        }
    }

    companion object {
        const val MOVIE_ITEM_TYPE = 1
        const val HEADER_ITEM_TYPE = 2
        const val WATCHED_ITEM_TYPE = 3
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) : BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup) : this(
                ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Movie) {
            binding.textCountryName.text = item.textMovieName
        }
    }

    class HeaderViewHolder(private val binding: ItemHeaderBinding) : BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
                ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Header) {
            binding.root.text = item.text
        }
    }

    inner class WatchedMoviesViewHolder(private val binding: CardViewBinding) : BaseViewHolder(binding.root) {

        constructor(parent: ViewGroup) : this(
                CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.WatchedMovie) {
            binding.textTitle.text = item.title
            binding.textDescription.text = item.description
            binding.img.setImageResource(item.image)

            binding.basket.setOnClickListener { listener.onDelete(item) }

        }
    }

    interface IMovieClick {
        fun onDelete(position: Item)
    }

}

object MoviesDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        when {
            oldItem is Item.WatchedMovie && newItem is Item.WatchedMovie -> {
                return oldItem.title == newItem.title
            }
            else -> return true
        }
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }


}
