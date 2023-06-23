package com.example.gridviewjetpackcompose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val text:Int, val likes:Int, @DrawableRes val imageId:Int)