package com.example.dell.fitwizv2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class health extends AppCompatActivity {

    DrawerLayout drawerLayout;
    FirebaseAuth mAuth;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        drawerLayout = findViewById(R.id.my_drawer_signed);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.profile:
                        Intent intent = new Intent(health.this, Account.class);
                        startActivity(intent);
                        break;
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

                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
    void goToHome() {
        Intent intent = new Intent(health.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
