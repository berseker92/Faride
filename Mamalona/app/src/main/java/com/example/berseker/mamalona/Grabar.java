package com.example.berseker.mamalona;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Grabar extends AppCompatActivity {

    private Button grabar, reproducir;
    private VideoView video;
    private int start = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grabar);

        grabar = (Button)findViewById(R.id.btnGrab);
        reproducir = (Button)findViewById(R.id.btnRep);
        video = (VideoView)findViewById(R.id.videoView);

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CallVideo = new Intent();
                CallVideo.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(CallVideo, start);
            }
        });

        reproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.start();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == start && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            video.setVideoURI(videoUri);
        }


    }

}
