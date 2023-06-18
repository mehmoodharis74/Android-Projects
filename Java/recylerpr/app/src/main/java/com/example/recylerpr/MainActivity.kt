package com.example.recylerpr

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    //create list of int photos
    var photos = ArrayList<items_container>()
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == 1000) {
                val recyclerView = findViewById<RecyclerView>(R.id.rv)
                recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

                //get uri of image
                //add uri to list
                data!!.data?.let { items_container(it) }?.let { photos.add(it) }
                //notify adapter
                val adapter = RecylerItemAdapter(this, photos)
                recyclerView.adapter = adapter
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val add = findViewById<Button>(R.id.btnAddImage)
        add.setOnClickListener { v: View? ->
            val iGallery = Intent(Intent.ACTION_PICK)
            iGallery.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(iGallery, 1000)
        }
        val adapter = RecylerItemAdapter(this, photos)
        recyclerView.adapter = adapter

        //create adapter
    }
}