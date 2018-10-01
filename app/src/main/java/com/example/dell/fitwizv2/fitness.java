package com.example.dell.fitwizv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class fitness extends AppCompatActivity {

    ImageView imageView;
    String url = "https://i.pinimg.com/564x/b2/45/37/b24537a5a41ca67dacfec5f3c2655ef9.jpg";
    Float angle = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        imageView = findViewById(R.id.imageView);

        loadImage(url, imageView);
    }
    private void loadImage(String url, ImageView imageView) {
        Picasso.with(this)
                .load(url)
                .resize(1200, 1400)
                .into(imageView);
    }
}
