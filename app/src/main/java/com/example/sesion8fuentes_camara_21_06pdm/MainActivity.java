package com.example.sesion8fuentes_camara_21_06pdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,new String [] {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},1000);
        }
    }

    static final int REQUEST_VIDEO_CAPTURE=1;
    public void videoCamara(View view){
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takeVideoIntent,REQUEST_VIDEO_CAPTURE);
        }
    }
}