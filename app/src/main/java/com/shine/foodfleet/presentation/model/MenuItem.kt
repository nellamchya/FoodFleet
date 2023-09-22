package com.shine.foodfleet.presentation.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItem(
    val name: String,
    val price: String,
    @DrawableRes val imageResourceId: Int,
    val rate: String,
    val description: String ,
    val location: String
) : Parcelable

