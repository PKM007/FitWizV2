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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class selectActitvity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button fitness,yoga,bulk,health;
    FirebaseAuth mAuth;
    ImageView fitnessImage,yogaImage,bulkImage,healthImage;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private TextView alertTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_actitvity);

        drawerLayout = findViewById(R.id.my_drawer_signed);
        navigationView = findViewById(R.id.nav_view);
        fitness=findViewById(R.id.fitnessButton);
        yoga=findViewById(R.id.yogaButton);
        bulk=findViewById(R.id.bulkButton);
        health=findViewById(R.id.healthButton);
        fitnessImage = findViewById(R.id.fitnessImage);
        yogaImage=findViewById(R.id.yogaImage);
        bulkImage=findViewById(R.id.bulkImage);
        healthImage=findViewById(R.id.healthImage);
        alertTextView = (TextView) findViewById(R.id.AlertTextView);

        actionBarDrawerToggle=new ActionBarDrawerToggle(selectActitvity.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Picasso.with(getApplicationContext()).load("http://english.samajalive.in/wp-content/uploads/2018/09/onlyfitness_cardio_1706x1280Px43-1024x768.jpg").into(fitnessImage);
        Picasso.with(getApplicationContext()).load("http://www.ogdoo.gr/media/k2/items/cache/1df09860aadc37ce4bd867cf5891b898_XL.jpg").into(yogaImage);
        Picasso.with(getApplicationContext()).load("https://www.bodybuilding.com/images/2017/october/bulking-made-easy-your-complete-guide-to-maximizing-muscle-growth-2-700xh.jpg").into(bulkImage);
        Picasso.with(getApplicationContext()).load("https://images.agoramedia.com/everydayhealth/gcms/cs-Simple-Tips-for-Your-Diabetes-Diet-1440x810.jpg?width=722").into(healthImage);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectActitvity.this,fitness.class);
                startActivity(intent);
            }
        });

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectActitvity.this,yoga.class);
                startActivity(intent);
            }
        });

        bulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectActitvity.this,bulk.class);
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selectActitvity.this,health.class);
                startActivity(intent);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {

                    case R.id.bmibmr:
                        Intent intent2 = new Intent(selectActitvity.this, UserDisplayActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.fitness:
                        Intent intent1 = new Intent(selectActitvity.this, fitness.class);
                        startActivity(intent1);
                        break;

                    case R.id.yoga:
                        Intent intent5 = new Intent(selectActitvity.this,yoga.class);
                        startActivity(intent5);
                        break;

                    case R.id.bulkncut:
                        Intent intent3 = new Intent(selectActitvity.this, bulk.class);
                        startActivity(intent3);
                        break;

                    case R.id.health:
                        Intent intent4 = new Intent(selectActitvity.this, health.class);
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(selectActitvity.this);

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
        Intent intent = new Intent(selectActitvity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
