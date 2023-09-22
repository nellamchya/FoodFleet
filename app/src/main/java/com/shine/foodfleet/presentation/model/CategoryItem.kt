package com.shine.foodfleet.presentation.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(@DrawableRes val imageResourceId: Int, val name: String) : Parcelable