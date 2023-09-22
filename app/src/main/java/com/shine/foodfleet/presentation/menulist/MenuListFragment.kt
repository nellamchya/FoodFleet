package com.shine.foodfleet.presentation.menulist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.shine.foodfleet.databinding.FragmentMenuListBinding
import com.shine.foodfleet.presentation.data.CategoryDataSource
import com.shine.foodfleet.presentation.data.CategoryDataSourceImpl
import com.shine.foodfleet.presentation.data.MenuDataSourceImpl
import com.shine.foodfleet.presentation.home.CategoryAdapter
import com.shine.foodfleet.presentation.menulist.adapter.MenuAdapter
import com.shine.foodfleet.presentation.model.MenuItem

class MenuListFragment : Fragment() {
    private lateinit var binding: FragmentMenuListBinding

    private val adapterCategory = CategoryAdapter()

    private val categoryDataSource: CategoryDataSource = CategoryDataSourceImpl()

    private val adapterMenu: MenuAdapter by lazy {
        MenuAdapter { menu ->
            navigateToFragmentDetailMenu(menuItem = menu)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showRecyclerCategories()
        showRecyclerMenu()
    }

    private fun showRecyclerMenu() {
        binding.recyclerViewMenu.adapter = adapterMenu
        binding.recyclerViewMenu.layoutManager = GridLayoutManager(requireContext(), 2)
        adapterMenu.setData(MenuDataSourceImpl().getMenu())
    }

    private fun navigateToFragmentDetailMenu(menuItem: MenuItem) {
        val action = MenuListFragmentDirections.actionMenuListFragmentToMenuDetailFragment(menuItem)
        findNavController().navigate(action)
    }

    private fun showRecyclerCategories() {
        binding.recyclerViewCategory.adapter = adapterCategory
        binding.recyclerViewCategory.layoutManager = GridLayoutManager(requireContext(), 4)
        adapterCategory.setData(categoryDataSource.getCategory())
    }
}
