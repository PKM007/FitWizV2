package com.example.dell.fitwizv2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.YuvImage;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class yoga extends AppCompatActivity {

    ImageView snImage, utImage, puImage, dfdImage, llImage, triangleImage;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FirebaseAuth mAuth;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private TextView alertTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
        drawerLayout = findViewById(R.id.my_drawer_signed);
        navigationView = findViewById(R.id.nav_view);
        snImage = findViewById(R.id.snImage);
        utImage = findViewById(R.id.utImage);
        puImage = findViewById(R.id.puImage);
        dfdImage = findViewById(R.id.dfdImage);
        llImage = findViewById(R.id.llImage);
        triangleImage = findViewById(R.id.tringleImage);
        alertTextView = (TextView) findViewById(R.id.AlertTextView);

        actionBarDrawerToggle=new ActionBarDrawerToggle(yoga.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                switch (menuItem.getItemId()) {

                    case R.id.bmibmr:
                        Intent intent2 = new Intent(yoga.this, UserDisplayActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.fitness:
                        Intent intent1 = new Intent(yoga.this, fitness.class);
                        startActivity(intent1);
                        break;

                    case R.id.yoga:
                        Toast.makeText(yoga.this,"You are currently in seleted activity",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.bulkncut:
                        Intent intent3 = new Intent(yoga.this, bulk.class);
                        startActivity(intent3);
                        break;

                    case R.id.health:
                        Intent intent4 = new Intent(yoga.this, health.class);
                        startActivity(intent4);
                        break;

                    case R.id.signout:
                        mAuth.signOut();
                        goToHome();
                        break;

                    case R.id.share:
                        Intent myIntent=new Intent(Intent.ACTION_SEND);
                        myIntent.setType("text/plain");
                        String shareBody="Hey Checkout This New App FitWiz Available At Play Store";
                        String shareSub="Your Subject here";
                        myIntent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                        myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                        startActivity(Intent.createChooser(myIntent,"Share using"));
                        break;

                    case R.id.contact:
                        Intent intent6=new Intent(Intent.ACTION_SEND);
                        intent6.setData(Uri.parse("mailto:"));
                        String[] to={"prakharmishra_anil@srmuniv.edu.in","prakhar.prakhar.mishra1@gmail.com"};
                        intent6.putExtra(Intent.EXTRA_EMAIL,to);
                        intent6.putExtra(Intent.EXTRA_SUBJECT,"Hi this is regarding FitWiz!");
                        intent6.putExtra(Intent.EXTRA_TEXT,"");
                        intent6.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent6,"Send Email"));
                        break;

                    case R.id.aboutus:
                        AlertDialog.Builder builder = new AlertDialog.Builder(yoga.this);

                        builder.setCancelable(true);
                        builder.setTitle("About Us");
                        builder.setMessage("We are a group that is trying to make people life easier and healthier. Thankyou!!");

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                alertTextView.setVisibility(View.VISIBLE);
                            }
                        });
                        builder.show();
                        break;


                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    void goToHome() {
        Intent intent = new Intent(yoga.this, MainActivity.class);
        startActivity(intent);
        finish();
    }



}

