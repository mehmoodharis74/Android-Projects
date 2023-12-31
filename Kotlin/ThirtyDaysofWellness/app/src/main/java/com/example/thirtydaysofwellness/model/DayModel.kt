package com.example.thirtydaysofwellness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DayModel (val day:Int, @StringRes val title:Int, @DrawableRes val imageRes:Int, @StringRes val description:Int
)