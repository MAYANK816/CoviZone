package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onlineDoc(View view) {
        startActivity(new Intent(this,online_Doctor.class));
    }

    public void oxygen(View view) {
        startActivity(new Intent(this,Oxygen.class));
    }

    public void findMedicine(View view) {
        startActivity(new Intent(this,find_Meadicine.class));
    }

    public void mealActivity(View view) {
        startActivity(new Intent(this,meals_Activity.class));
    }
}