package com.geektech.pixabay44

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.geektech.pixabay44.databinding.ItemImagesBinding
import com.geektech.pixabay44.model.ImageModel

class ImageAdapter(private val list: ArrayList<ImageModel>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageAdapter.ImageViewHolder {
        val binding = ItemImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageAdapter.ImageViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addlist(model: ArrayList<ImageModel>) {
        list.addAll(model)
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(val binding: ItemImagesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: ImageModel) {
            binding.pixabayImage.load(model.largeImageURL)

        }

    }
}