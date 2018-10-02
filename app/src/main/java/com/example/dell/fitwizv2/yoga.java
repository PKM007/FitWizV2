package com.example.dell.fitwizv2;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class yoga extends AppCompatActivity {

    ImageView snImage,utImage,puImage,dfdImage,llImage,triangleImage;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
        drawerLayout = findViewById(R.id.my_drawer_signed);
        navigationView = findViewById(R.id.nav_view);
        snImage = findViewById(R.id.snImage);
        utImage=findViewById(R.id.utImage);
        puImage=findViewById(R.id.puImage);
        dfdImage=findViewById(R.id.dfdImage);
        llImage=findViewById(R.id.llImage);
        triangleImage=findViewById(R.id.tringleImage);

        Picasso.with(getApplicationContext()).load("https://satiyoga.eu/images/suryanamaskar.png").into(snImage);
        Picasso.with(getApplicationContext()).load("https://cdn2.stylecraze.com/wp-content/uploads/2013/08/Utkatasana-1.jpg").into(utImage);
        Picasso.with(getApplicationContext()).load("https://i.pinimg.com/originals/d6/4c/ff/d64cff7cd861ab8729dc0b702af4b449.jpg").into(puImage);
        Picasso.with(getApplicationContext()).load("https://i2.wp.com/blog.codyapp.com/wp-content/uploads/2014/03/downward-dog-technique1.jpg").into(dfdImage);
        Picasso.with(getApplicationContext()).load("https://i.ytimg.com/vi/aOfniMZY2hk/maxresdefault.jpg").into(llImage);
        Picasso.with(getApplicationContext()).load("https://i.pinimg.com/originals/ed/7c/8f/ed7c8f8a5200ca132c00e44aefff88a3.jpg").into(triangleImage);
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
