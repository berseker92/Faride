package com.example.berseker.mamalona;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Button btnvideo,btnimg,btnmps;
    private ToggleButton blueto;
    BluetoothAdapter blueadp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    btnvideo =(Button)findViewById(R.id.btnvideo);
   blueto = (ToggleButton)findViewById(R.id.btnblue);
    btnimg = (Button)findViewById(R.id.btnimg);
   btnmps =(Button)findViewById(R.id.btnmps);
        blueadp = BluetoothAdapter.getDefaultAdapter();




    btnvideo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent llamar = new Intent(MainActivity.this,Grabar.class);
            startActivity(llamar);

        }
    });


        btnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ls = new  Intent(MainActivity.this,Foto.class);
                startActivity(ls);
            }
        });




        btnmps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maps  = new Intent(MainActivity.this,Mapas.class);
                startActivity(maps);

            }
        });




     blueto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

         if(isChecked){

             startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),0);


         }
         else{
             blueadp.disable();

         }

         }
     });






    }
}
