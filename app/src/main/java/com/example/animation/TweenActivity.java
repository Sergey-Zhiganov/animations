package com.example.animation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class TweenActivity extends AppCompatActivity {

    private ImageView img;
    private Button startBtn;
    private Button pauseBtn;
    private Button return_tween;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        ConstraintLayout mainLayout = findViewById(R.id.main);
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_anim_tween);
        mainLayout.setLayoutAnimation(animation);

        img = findViewById(R.id.img_blink);
        startBtn = findViewById(R.id.start_tween);
        pauseBtn = findViewById(R.id.pause_tween);
        return_tween = findViewById(R.id.return_tween);

        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);

        startBtn.setOnClickListener(v -> img.startAnimation(blinkAnimation));

        pauseBtn.setOnClickListener(v -> img.clearAnimation());

        return_tween.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.enter_menu_activity_tween, R.anim.exit_tween_activity);
        });
    }
}