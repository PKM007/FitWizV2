package com.example.dell.fitwizv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import java.lang.Object;

import com.squareup.picasso.Picasso;

public class fitness extends AppCompatActivity {

    ImageView squadImage,crunchImage,pushupImage,jumpingjackImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        squadImage = findViewById(R.id.squadImage);
        crunchImage=findViewById(R.id.crunchImage);
        pushupImage=findViewById(R.id.pushupImage);
        jumpingjackImage=findViewById(R.id.jumpingjackImage);

        Picasso.with(getApplicationContext()).load("https://bodyformfitness.com/wp-content/uploads/2016/02/squatting-exercises.jpg").into(squadImage);
        Picasso.with(getApplicationContext()).load("http://www.themusclesecrets.com/images/abdominal-crunches-end.png").into(crunchImage);
        Picasso.with(getApplicationContext()).load("https://static.vecteezy.com/system/resources/previews/000/162/096/non_2x/man-doing-push-up-vector-illustration.jpg").into(pushupImage);
        Picasso.with(getApplicationContext()).load("https://cdn.instructables.com/FLV/BN83/I8SLTHTQ/FLVBN83I8SLTHTQ.LARGE.jpg").into(jumpingjackImage);
    }
}
