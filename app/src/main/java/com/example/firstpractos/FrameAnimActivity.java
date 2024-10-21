package com.example.firstpractos;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FrameAnimActivity extends AppCompatActivity {

    private ImageView animatonTV;
    private Button startBtn;
    private Button pauseBtn;
    private AnimationDrawable frameAnimation;
    private Button main_teleport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frame_anim);

        animatonTV = findViewById(R.id.frameAnimImageView);
        startBtn = findViewById(R.id.startButton);
        pauseBtn = findViewById(R.id.stopButton);
        frameAnimation = (AnimationDrawable) animatonTV.getDrawable();
        main_teleport = findViewById(R.id.frame_to_main);

        startBtn.setOnClickListener( v -> {
            if (!frameAnimation.isRunning()){
                frameAnimation.start();
            }
        });

        pauseBtn.setOnClickListener(v -> {
            if(frameAnimation.isRunning()){
                frameAnimation.stop();
            }
        });

        main_teleport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FrameAnimActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.maximize_animation, R.anim.reverse_maximize);

            }
        });
    }
}