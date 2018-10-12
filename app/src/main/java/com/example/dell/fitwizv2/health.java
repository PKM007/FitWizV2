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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class health extends AppCompatActivity {

    DrawerLayout drawerLayout;
    FirebaseAuth mAuth;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private TextView alertTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        drawerLayout = findViewById(R.id.my_drawer_signed);
        navigationView = findViewById(R.id.nav_view);
        alertTextView = (TextView) findViewById(R.id.AlertTextView);

        actionBarDrawerToggle=new ActionBarDrawerToggle(health.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {

                    case R.id.bmibmr:
                        Intent intent1 = new Intent(health.this, UserDisplayActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.fitness:
                        Intent intent3 = new Intent(health.this, fitness.class);
                        startActivity(intent3);
                        break;

                    case R.id.yoga:
                        Intent intent2 = new Intent(health.this, yoga.class);
                        startActivity(intent2);
                        break;

                    case R.id.bulkncut:
                        Intent intent4 = new Intent(health.this, bulk.class);
                        startActivity(intent4);
                        break;

                    case R.id.health:
                        Toast.makeText(health.this,"You are currently in seleted activity",Toast.LENGTH_SHORT).show();
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(health.this);

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
        Intent intent = new Intent(health.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
