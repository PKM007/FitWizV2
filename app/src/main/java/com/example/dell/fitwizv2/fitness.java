package com.example.dell.fitwizv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import java.lang.Object;

import com.squareup.picasso.Picasso;

public class fitness extends AppCompatActivity {

    ImageView squadImage,crunchImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        squadImage = findViewById(R.id.squadImage);
        crunchImage=findViewById(R.id.crunchImage);

        Picasso.with(getApplicationContext()).load("https://bodyformfitness.com/wp-content/uploads/2016/02/squatting-exercises.jpg").into(squadImage);
        Picasso.with(getApplicationContext()).load("http://www.themusclesecrets.com/images/abdominal-crunches-end.png").into(crunchImage);

    }
}
