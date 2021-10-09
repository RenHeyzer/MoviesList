package com.example.movieslist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieslist.databinding.ItemMovieBinding
import com.example.movieslist.interfaces.OnItemClickListener
import com.example.movieslist.models.Movie
import com.example.movieslist.utils.loadImage

class MovieAdapter(private var pListener: OnItemClickListener) :
    androidx.recyclerview.widget.ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffUtil()) {

    class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    inner class MovieViewHolder(
        private val itemBinding: ItemMovieBinding, private val listener: OnItemClickListener
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(item: Movie) {
            itemBinding.apply {
                itemBinding.itemMovieTitle.text = item.name
                itemBinding.itemMovieImage.loadImage(item.image.original)
                itemView.setOnClickListener {
                    listener.onItemClick(item.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), pListener
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}