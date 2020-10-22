package com.jatin.videorecoderapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRecord, btnPlay;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnRecord = findViewById(R.id.btnRecord);
        videoView = findViewById(R.id.videoView);

        btnRecord.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnRecord:
            {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent,111);
                break;
            }
            case R.id.btnPlay:
            {
                videoView.start();
                break;
            }
        }
   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==111 && resultCode==RESULT_OK)
        {
            videoView.setVideoURI(data.getData());

        }
    }


}