package com.example.berseker.mamalona;


import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Foto extends AppCompatActivity {

private Button btnfoto;
private ImageView mostrarfoto;

static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        btnfoto = (Button) findViewById(R.id.btnfoto);
        mostrarfoto = (ImageView) findViewById(R.id.mostrarfoto);


        btnfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarIntent();
            }
        });
    }


        private void llamarIntent(){

            Intent take = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(take.resolveActivity(getPackageManager()) !=null)
         {
             startActivityForResult(take,REQUEST_IMAGE_CAPTURE);
        }
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap =(Bitmap)extras.get("data");
            mostrarfoto.setImageBitmap(imageBitmap);

        }

    }


}
