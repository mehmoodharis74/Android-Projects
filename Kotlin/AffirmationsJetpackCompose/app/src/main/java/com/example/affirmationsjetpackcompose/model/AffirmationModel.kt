package com.example.affirmationsjetpackcompose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AffirmationModel(
     val textId:String,
    @DrawableRes val imageId:Int) {

}