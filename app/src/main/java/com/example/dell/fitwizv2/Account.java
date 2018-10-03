package com.example.dell.fitwizv2;

import android.arch.core.executor.DefaultTaskExecutor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Account extends AppCompatActivity {

    TextView msgtext;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference mRootReference=firebaseDatabase.getReference();
    DatabaseReference mChildReference=mRootReference.child("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        msgtext=findViewById(R.id.msgtext);

    }

    
}
