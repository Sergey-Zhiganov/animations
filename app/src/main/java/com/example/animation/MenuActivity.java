package com.example.animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MenuActivity extends AppCompatActivity {
    private Button frameBtn;
    private Button tweenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ConstraintLayout mainLayout = findViewById(R.id.main);
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_anim_menu);
        mainLayout.setLayoutAnimation(animation);

        frameBtn = findViewById(R.id.frame);
        tweenBtn = findViewById(R.id.tween);

        frameBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, FrameActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.enter_frame_activity, R.anim.exit_menu_activity_frame);
        });

        tweenBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, TweenActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.enter_tween_activity, R.anim.exit_menu_activity_tween);
        });
    }
}