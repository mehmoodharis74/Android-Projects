package com.harismehmood.cloud_storage_task;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {

    EditText img_url;
    Button btn_pick;
    ImageView imgGallery;
    Uri uri=null;
    StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_url=findViewById(R.id.edt_url);
        btn_pick=findViewById(R.id.btn_image);
        imgGallery=findViewById(R.id.imgGallery);
        FirebaseStorage storage = FirebaseStorage.getInstance();

        storageRef = storage.getReference();

        btn_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode==RESULT_OK)
        {

            imgGallery.setImageURI(data.getData());
            uri=(Uri)data.getData();  //save uri for further processing

        }
        img_url.setText(uri.toString());
        uploadImage();  //user defined function to upload image on Cloud storage


    }

    private void uploadImage() {

        // Create a reference to "mountains.jpg"
        StorageReference mountainsRef = storageRef.child("mountains.jpg");

// Create a reference to 'images/mountains.jpg'
        StorageReference mountainImagesRef = storageRef.child("images/mountains.jpg");

// While the file names are the same, the references point to different files
        mountainsRef.getName().equals(mountainImagesRef.getName());    // true
        mountainsRef.getPath().equals(mountainImagesRef.getPath());

        mountainsRef.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        Task<Uri> resultTask = taskSnapshot.getStorage().getDownloadUrl();
                        resultTask.addOnSuccessListener(new OnSuccessListener<Uri>()
                        {
                            @Override
                            public void onSuccess(Uri uri)
                            {
                                Toast.makeText(MainActivity.this, "Uploaded", Toast.LENGTH_LONG).show();
                                img_url.setText(uri.toString());
                            }
                        }).addOnFailureListener(new OnFailureListener()
                        {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {
                                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
    }
}