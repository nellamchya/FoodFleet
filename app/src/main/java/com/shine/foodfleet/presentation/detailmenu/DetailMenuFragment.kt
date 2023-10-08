package com.shine.foodfleet.presentation.detailmenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.load
import androidx.navigation.fragment.navArgs
import com.shine.foodfleet.databinding.FragmentDetailMenuBinding
import com.shine.foodfleet.presentation.model.MenuItem

class DetailMenuFragment : Fragment() {

    private lateinit var binding: FragmentDetailMenuBinding

    private val menuItem: MenuItem? by lazy {
        DetailMenuFragmentArgs.fromBundle(requireArguments()).menuList
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showMenuItemData()
        setClickListener()
    }

    private fun showMenuItemData() {
        menuItem?.let { item ->
            binding.apply {
                menuTitle.text = item.name
                menuPrice2.text = item.price
                menuImage.load(item.imageResourceId)
                menuDescription.text = item.description
            }
        }
    }

    private fun setClickListener() {
        binding.btnOpenMaps.setOnClickListener {
            val data = binding.btnOpenMaps.text.toString()
            val uri = Uri.parse("https://maps.app.goo.gl/JcYJNo5sbQu1V7sp8")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent.setPackage("com.google.android.apps.maps")

            if (mapIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(mapIntent)
            } else {
                val browserMapIntent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(browserMapIntent)
            }
        }
    }
}

