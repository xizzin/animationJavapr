package com.example.firstpractos;

import android.content.Intent;
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

public class TweenAnimActivity extends AppCompatActivity {
    private ImageView img;
    private Button startBtn;
    private Button pauseBtn;
    private Button main_from_tween_teleport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tween_anim);
        img=findViewById(R.id.img_blink);
        startBtn=findViewById(R.id.start_tween);
        pauseBtn=findViewById(R.id.pause_tween);
        main_from_tween_teleport = findViewById(R.id.main_to);
        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);

        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ img.startAnimation(blinkAnimation);}
        });

        pauseBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {img.clearAnimation();}

        });

        main_from_tween_teleport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(TweenAnimActivity.this, MainActivity.class));
               overridePendingTransition(R.anim.diagonal_back_in, R.anim.diagonal_back_out);
            }
        });
    }
}