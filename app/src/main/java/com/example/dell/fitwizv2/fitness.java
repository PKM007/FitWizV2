package com.example.dell.fitwizv2;

import android.content.DialogInterface;
import android.content.Intent;
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

import java.lang.Object;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class fitness extends AppCompatActivity {

    ImageView squadImage,crunchImage,pushupImage,jumpingjackImage,glutebridgeImage,lungesImage,plankImage;
    DrawerLayout drawerLayout;
    FirebaseAuth mAuth;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private TextView alertTextView;

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
        lungesImage=findViewById(R.id.lungesImage);
        plankImage=findViewById(R.id.plankImage);
        alertTextView = (TextView) findViewById(R.id.AlertTextView);

        actionBarDrawerToggle=new ActionBarDrawerToggle(fitness.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Picasso.with(getApplicationContext()).load("https://bodyformfitness.com/wp-content/uploads/2016/02/squatting-exercises.jpg").into(squadImage);
        Picasso.with(getApplicationContext()).load("http://www.themusclesecrets.com/images/abdominal-crunches-end.png").into(crunchImage);
        Picasso.with(getApplicationContext()).load("https://static.vecteezy.com/system/resources/previews/000/162/096/non_2x/man-doing-push-up-vector-illustration.jpg").into(pushupImage);
        Picasso.with(getApplicationContext()).load("https://cdn.instructables.com/FLV/BN83/I8SLTHTQ/FLVBN83I8SLTHTQ.LARGE.jpg").into(jumpingjackImage);
        Picasso.with(getApplicationContext()).load("http://cdn1.coachmag.co.uk/sites/coachmag/files/styles/insert_main_wide_image/public/images/dir_31/mens_fitness_15769.jpg?itok=ZMvl3V6P").into(glutebridgeImage);
        Picasso.with(getApplicationContext()).load("https://images.huffingtonpost.com/2014-08-27-chrislunge-thumb.png").into(lungesImage);
        Picasso.with(getApplicationContext()).load("http://crossfitzonex.com/wp-content/uploads/2013/09/FocusOnForm_ForearmPlank.jpg").into(plankImage);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {

                    case R.id.bmibmr:
                        Intent intent1 = new Intent(fitness.this, UserDisplayActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.fitness:
                        Toast.makeText(fitness.this,"You are currently in seleted activity",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.yoga:
                        Intent intent2 = new Intent(fitness.this, yoga.class);
                        startActivity(intent2);
                        break;

                    case R.id.bulkncut:
                        Intent intent3 = new Intent(fitness.this, bulk.class);
                        startActivity(intent3);
                        break;

                    case R.id.health:
                        Intent intent4 = new Intent(fitness.this, health.class);
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(fitness.this);

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
        Intent intent = new Intent(fitness.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
