package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Model(@StringRes val nameRes:Int, @StringRes val descriptionRes:Int, @DrawableRes val imageRes:Int)