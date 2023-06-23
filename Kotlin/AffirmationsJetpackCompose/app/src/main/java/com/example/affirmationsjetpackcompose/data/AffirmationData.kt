package com.example.affirmationsjetpackcompose.data

import com.example.affirmationsjetpackcompose.R
import com.example.affirmationsjetpackcompose.model.AffirmationModel

class AffirmationData() {
    fun loadData():List<AffirmationModel>{
        return listOf<AffirmationModel>(
            AffirmationModel("Text 1", R.drawable.a1),
            AffirmationModel("Text 2", R.drawable.a2),
            AffirmationModel("Text 3", R.drawable.a3),
            AffirmationModel("Text 4", R.drawable.a4)
        )
    }
}