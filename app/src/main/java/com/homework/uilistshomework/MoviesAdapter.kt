package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.databinding.CardViewBinding
import com.homework.uilistshomework.databinding.ItemHeaderBinding
import com.homework.uilistshomework.databinding.ItemMovieBinding


class MoviesAdapter: ListAdapter<Item.WatchedMovie, BaseViewHolder>(MoviesDiffCallback()) {

    var list: List<Item> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            MOVIE_ITEM_TYPE -> MovieViewHolder(parent)
            HEADER_ITEM_TYPE -> HeaderViewHolder(parent)
            else -> WatchedMoviesViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(val item = list[position]){
            is Item.Movie -> (holder as MovieViewHolder).bind(item)
            is Item.Header -> (holder as HeaderViewHolder).bind(item)
            is Item.WatchedMovie -> (holder as WatchedMoviesViewHolder).bind(item)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]){
            is Item.Movie -> MOVIE_ITEM_TYPE
            is Item.Header -> HEADER_ITEM_TYPE
            is Item.WatchedMovie -> WATCHED_ITEM_TYPE
        }
    }

    companion object{
        const val MOVIE_ITEM_TYPE = 1
        const val HEADER_ITEM_TYPE = 2
        const val WATCHED_ITEM_TYPE = 3
    }

    class MovieViewHolder(private val binding: ItemMovieBinding): BaseViewHolder(binding.root){

        constructor(parent: ViewGroup): this(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Movie) {
            val binding = ItemMovieBinding.bind(itemView)
            binding.textCountryName.text = item.textMovieName
        }
    }

    class HeaderViewHolder(private val binding: ItemHeaderBinding): BaseViewHolder(binding.root){
        constructor(parent: ViewGroup): this(
            ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.Header){
            binding.root.text = item.text
        }
    }

    class WatchedMoviesViewHolder(private val binding: CardViewBinding): BaseViewHolder(binding.root){

        constructor(parent: ViewGroup): this(
            CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: Item.WatchedMovie){
            val binding = CardViewBinding.bind(itemView)
            binding.textTitle.text = item.title
            binding.textDescription.text = item.description
            binding.img.setImageResource(item.image)

            binding.basket.setOnClickListener(object: View.OnClickListener {
                override fun onClick(v: View?) {

                }

            })

        }
    }

    interface IMovieClick{
        fun onDelete(position: Int)
    }

}

class MoviesDiffCallback: DiffUtil.ItemCallback<Item.WatchedMovie>(){
    override fun areItemsTheSame(oldItem: Item.WatchedMovie, newItem: Item.WatchedMovie): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Item.WatchedMovie, newItem: Item.WatchedMovie): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }


}
