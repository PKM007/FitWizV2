package com.example.dell.fitwizv2;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import java.lang.Object;

import com.squareup.picasso.Picasso;

public class fitness extends AppCompatActivity {

    ImageView squadImage,crunchImage,pushupImage,jumpingjackImage,glutebridgeImage;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        drawerLayout = findViewById(R.id.my_drawer_signed);
        navigationView = findViewById(R.id.nav_view);
        squadImage = findViewById(R.id.squadImage);
        crunchImage=findViewById(R.id.crunchImage);
        pushupImage=findViewById(R.id.pushupImage);
        jumpingjackImage=findViewById(R.id.jumpingjackImage);
        glutebridgeImage=findViewById(R.id.glutebridgeImage);

        Picasso.with(getApplicationContext()).load("https://bodyformfitness.com/wp-content/uploads/2016/02/squatting-exercises.jpg").into(squadImage);
        Picasso.with(getApplicationContext()).load("http://www.themusclesecrets.com/images/abdominal-crunches-end.png").into(crunchImage);
        Picasso.with(getApplicationContext()).load("https://static.vecteezy.com/system/resources/previews/000/162/096/non_2x/man-doing-push-up-vector-illustration.jpg").into(pushupImage);
        Picasso.with(getApplicationContext()).load("https://cdn.instructables.com/FLV/BN83/I8SLTHTQ/FLVBN83I8SLTHTQ.LARGE.jpg").into(jumpingjackImage);
        Picasso.with(getApplicationContext()).load("http://cdn1.coachmag.co.uk/sites/coachmag/files/styles/insert_main_wide_image/public/images/dir_31/mens_fitness_15769.jpg?itok=ZMvl3V6P").into(glutebridgeImage);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
