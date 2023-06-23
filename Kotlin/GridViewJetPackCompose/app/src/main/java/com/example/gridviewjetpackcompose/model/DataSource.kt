package com.example.gridviewjetpackcompose.model

import com.example.gridviewjetpackcompose.R

class DataSource() {

        fun loadData():List<Topic>{
        return listOf(
            Topic(R.string.architecture, 58, R.drawable.a1),
            Topic(R.string.crafts, 121, R.drawable.a2),
            Topic(R.string.business, 78, R.drawable.a3),
            Topic(R.string.culinary, 118, R.drawable.a4),
            Topic(R.string.design, 423, R.drawable.a5),
            Topic(R.string.fashion, 92, R.drawable.a6),
            Topic(R.string.film, 165, R.drawable.a7),
            Topic(R.string.gaming, 164, R.drawable.a8),
            Topic(R.string.drawing, 326, R.drawable.a9),
            Topic(R.string.lifestyle, 305, R.drawable.a10),
            Topic(R.string.music, 212, R.drawable.a11),
            Topic(R.string.painting, 172, R.drawable.a6),
            Topic(R.string.photography, 321, R.drawable.a3),
            Topic(R.string.tech, 118, R.drawable.a7)
        )
    }
    }
