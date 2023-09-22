package com.shine.foodfleet.presentation.data

import com.shine.foodfleet.R
import com.shine.foodfleet.presentation.model.MenuItem

interface MenuDataSource {
    fun getMenu(): List<MenuItem>
}

class MenuDataSourceImpl() : MenuDataSource {
    override fun getMenu(): List<MenuItem> {
        return listOf(
            MenuItem(
                "Ayam Goreng",
                "Rp 20.000",
                R.drawable.ic_ayamm,
                "4.5",
                "Potongan ayam yang digoreng garing dengan rempah-rempah, cocok untuk pecinta makanan gurih.",
                "Lokasi Restoran XYZ"
            ),
            MenuItem(
                "Burger",
                "Rp 25.000",
                R.drawable.ic_burger,
                "4.2",
                "Burger lezat dengan patty daging, sayuran segar dan saus spesial.",
                "Lokasi Restoran XYZ"
            ),
            MenuItem(
                "Sate Ayam",
                "Rp 30.000",
                R.drawable.ic_sate_ayam,
                "4.8",
                "Potongan-potongan ayam yang dipanggang dengan bumbu kacang khas, memberikan cita rasa manis dan pedas.",
                "Lokasi Restoran XYZ"
            ),
            MenuItem(
                "Spaghetti",
                "Rp 22.000",
                R.drawable.ic_spaghetti,
                "4.4",
                "Pasta lezat dengan saus tomat dan daging cincang, disajikan dengan keju parmesan yang meleleh.",
                "Lokasi Restoran XYZ"
            ),
            MenuItem(
                "Sushi",
                "Rp 18.000",
                R.drawable.ic_sushi,
                "4.6",
                "Gumpalan nasi yang dilapisi dengan potongan ikan segar, cocok untuk pencinta hidangan Jepang.",
                "Lokasi Restoran XYZ"
            ),
            MenuItem(
                "Ramen",
                "Rp 15.000",
                R.drawable.ic_ramen,
                "4.0",
                "Mie gandum dengan kuah kaldu lezat, dilengkapi dengan irisan daging dan sayuran.",
                "Lokasi Restoran XYZ"
            ),
            MenuItem(
                "Kentang Goreng",
                "Rp 12.000",
                R.drawable.ic_kentang_goreng,
                "4.3",
                "Kentang potong yang digoreng hingga renyah, cocok sebagai camilan atau pendamping hidangan.",
                "Lokasi Restoran XYZ"
            )
        )
    }
}
