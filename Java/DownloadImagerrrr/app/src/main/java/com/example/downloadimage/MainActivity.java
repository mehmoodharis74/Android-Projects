package com.example.downloadimage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private final int GALLERY_REQ_CODE=1000;
    ImageView imgGallery,imgGallery2;
    Button btn_Download;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgGallery=findViewById(R.id.imgGallery);
        imgGallery2=findViewById(R.id.imgGallery2);
        btn_Download=findViewById(R.id.btn_Download);

        btn_Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iGallery=new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery,GALLERY_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri=null;
        if(resultCode==RESULT_OK)
        {

            if(requestCode==GALLERY_REQ_CODE)

            {  imgGallery.setImageURI(data.getData());
                  uri=(Uri)data.getData();  //save uri for further processing
            }
            }
        imgGallery2.setImageURI(uri);
    }
}