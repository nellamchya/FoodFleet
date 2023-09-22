package com.shine.foodfleet.presentation.menulist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shine.foodfleet.databinding.ItemMenuGridBinding
import com.shine.foodfleet.presentation.model.MenuItem

class MenuAdapter(private val onItemClick: (MenuItem) -> Unit) :
    RecyclerView.Adapter<MenuAdapter.MenuItemListViewHolder>() {

    private val dataDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<MenuItem>() {
        override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem == newItem
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemListViewHolder {
        val binding = ItemMenuGridBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MenuItemListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: MenuItemListViewHolder, position: Int) {
        holder.bind(dataDiffer.currentList[position])
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    fun setData(data: List<MenuItem>) {
        dataDiffer.submitList(data)
    }

    inner class MenuItemListViewHolder(
        private val binding: ItemMenuGridBinding,
        private val onItemClick: (MenuItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(menu: MenuItem) {
            with(binding) {
                menuItemName.text = menu.name
                menuItemPrice.text = menu.price
                menuItemImage.load(menu.imageResourceId)
                menuItemRate.text = menu.rate
                menuItemDescription.text = menu.description
            }

            binding.root.setOnClickListener {
                onItemClick(menu)
            }
        }
    }
}
