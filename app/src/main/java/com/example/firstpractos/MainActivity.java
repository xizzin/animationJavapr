package com.example.firstpractos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button frame_teleport;
    private Button tween_teleport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        frame_teleport = findViewById(R.id.frame_go_button);
        tween_teleport = findViewById(R.id.tween_go_button);

        frame_teleport.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
             startActivity(new Intent(MainActivity.this, FrameAnimActivity.class));
             overridePendingTransition(R.anim.diagonal_back_in, R.anim.diagonal_back_out);
            }
        });

        tween_teleport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TweenAnimActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}