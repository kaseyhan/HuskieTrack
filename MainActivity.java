package com.example.rikit.shootermap;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        EditText classNum = (EditText)findViewById(R.id.classNum);
        String number = classNum.getText().toString();
        int num = Integer.parseInt(number);
        Intent intent = new Intent(MainActivity.this, FloorPlan.class);
        intent.putExtra("CLASSNUM", num);
        startActivity(intent);
    }
}
