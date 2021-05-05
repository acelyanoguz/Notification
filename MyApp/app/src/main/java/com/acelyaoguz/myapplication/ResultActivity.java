package com.acelyaoguz.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Bildirime basıldıktan sonra yönlendirileceği sayfa tanımı
        setContentView(R.layout.result_activity);
    }
}
