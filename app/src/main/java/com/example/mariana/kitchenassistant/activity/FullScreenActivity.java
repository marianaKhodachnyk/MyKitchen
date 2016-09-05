package com.example.mariana.kitchenassistant.activity;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.mariana.kitchenassistant.R;
import com.example.mariana.kitchenassistant.TouchImageView;

public class FullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        String image_id = this.getIntent().getStringExtra("image_id");
        
        final TouchImageView img = (TouchImageView)findViewById(R.id.imageView);
        Glide.with(getApplicationContext()).load(image_id).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                img.setImageBitmap(resource);
            }
        });

    }

}
