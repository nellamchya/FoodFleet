package com.shine.foodfleet.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shine.foodfleet.databinding.ItemCategoryBinding
import com.shine.foodfleet.presentation.model.Category


class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryItemListViewHolder>() {

    private val dataDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.name == newItem.name && oldItem.imageResourceId == newItem.imageResourceId
        }


        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemListViewHolder {
        return CategoryItemListViewHolder(
            binding = ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryItemListViewHolder, position: Int) {
        holder.bind(dataDiffer.currentList[position])
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    fun setData(data: List<Category>) {
        dataDiffer.submitList(data)
        notifyDataSetChanged()
    }

    inner class CategoryItemListViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            with(binding) {
                categoryImage.load(category.imageResourceId)
                categoryName.text = category.name
            }
        }
    }
}
