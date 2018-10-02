package com.example.dell.fitwizv2;

import android.app.Activity;
import java.math.*;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserDisplayActivity extends AppCompatActivity {

    EditText weight,height,age;
    Button calculateBMI,sActivity;
    RadioButton male,female;
    TextView resultBMI,resultBMR;
    FirebaseAuth mAuth;
    Button signOut;
    boolean doubleBackToExitPressedOnce = false;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_display);
        drawerLayout = findViewById(R.id.my_drawer_signed);
        navigationView = findViewById(R.id.nav_view);
        mAuth = FirebaseAuth.getInstance();
        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        age=findViewById(R.id.age);
        resultBMI=findViewById(R.id.resultBMI);
        resultBMR=findViewById(R.id.resultBMR);
        calculateBMI=findViewById(R.id.calulateBMI);
        sActivity=findViewById(R.id.selectActivity);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setSelected(true);
                female.setSelected(false);
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setSelected(true);
                male.setSelected(false);
            }
        });



            calculateBMI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(male.isSelected()==true)
                    {
                        mcalulate();
                    }
                    else if(female.isSelected()==true)
                    {
                        fcalculate();
                    }
                    else{
                        Toast.makeText(UserDisplayActivity.this,"Please Select Any Gender",Toast.LENGTH_SHORT).show();
                    }
                }
            });



        sActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sActivity();
            }
        });

        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        signOut = findViewById(R.id.signout);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });


        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                goToHome();
            }
        });
    }

    public void mcalulate()
    {
        String weightstr=weight.getText().toString();
        String heightstr=height.getText().toString();
        String agestr=height.getText().toString();
        if(heightstr !=null && !"".equals(heightstr) && weightstr !=null && !"".equals(weightstr))
        {
            float heightValue=Float.parseFloat(heightstr);
            float weightValue=Float.parseFloat(weightstr);
            int ageValue=Integer.parseInt(agestr);
            float bmi=10000*weightValue/(heightValue*heightValue);
            if(bmi<18.5)
            {
                resultBMI.setText("You Are Underweight \n Your BMI is- "+bmi);
            }
            else if(bmi>=18.5 && bmi<24.9)
            {
                resultBMI.setText(" You Are Normal \nYour BMI is- "+bmi);
            }
            else if(bmi>24.9 && bmi<29.9)
            {
                resultBMI.setText("You Are Overweight \nYour BMI is- "+bmi);
            }
            else
            {
                resultBMI.setText("You are Obese\nYour BMI is- "+bmi);
            }
            double bmr=66+(13.7*weightValue)+(5*heightValue)-(6.8*ageValue);
            int fbmr=(int)bmr;
            resultBMR.setText("Your Calorie Intake is-"+fbmr);

        }
    }

    public void fcalculate()
    {
        String weightstr=weight.getText().toString();
        String heightstr=height.getText().toString();
        String agestr=height.getText().toString();
        if(heightstr !=null && !"".equals(heightstr) && weightstr !=null && !"".equals(weightstr))
        {
            float heightValue=Float.parseFloat(heightstr);
            float weightValue=Float.parseFloat(weightstr);
            float ageValue=Float.parseFloat(agestr);
            float bmi=10000*weightValue/(heightValue*heightValue);
            if(bmi<18.5)
            {
                resultBMI.setText("You Are Underweight \n Your BMI is- "+bmi);
            }
            else if(bmi>=18.5 && bmi<24.9)
            {
                resultBMI.setText(" You Are Normal \nYour BMI is- "+bmi);
            }
            else if(bmi>24.9 && bmi<29.9)
            {
                resultBMI.setText("You Are Overweight \nYour BMI is- "+bmi);
            }
            else
            {
                resultBMI.setText("You are Obese\nYour BMI is- "+bmi);
            }
            double bmr=655+(9.6*weightValue)+(1.8*heightValue)-(4.7*ageValue);
            int fbmr=(int)bmr;
            resultBMR.setText("Your Calorie Intake is- "+fbmr);

        }
    }

    public void sActivity()
    {
        Intent intent=new Intent(UserDisplayActivity.this,selectActitvity.class);
        startActivity(intent);
        finish();
    }

    void goToHome() {
        Intent intent = new Intent(UserDisplayActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            goToHome();
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to SignOut", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}