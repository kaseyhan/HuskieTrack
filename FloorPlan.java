package com.example.rikit.shootermap;

import android.content.Intent;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class FloorPlan extends AppCompatActivity {
    int classNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_plan);

        Intent intent = getIntent();
        classNum = intent.getIntExtra("CLASSNUM", 0);

        TextView timer = (TextView) findViewById(R.id.policeTime);
        upDate();
        for(int i = 0; i < 10; i++){
            try{
                TimerThread thread = new TimerThread();
                thread.start();
                timer.setText(thread.timeToString());
            }
            catch (Exception e){}
        }
    }

    public void upDate(){
        TextView loc = (TextView)findViewById(R.id.locAns);
        TextView dist = (TextView)findViewById(R.id.distAns);
        TextView time = (TextView)findViewById(R.id.timeAns);
        loc.setText("Classroom 1");

        switch (classNum){
            case 2:
                dist.setText("3 meters");
                time.setText("1 minute away");
            case 3:
                dist.setText("7 meters");
                time.setText("5 minute away");
            case 4:
                dist.setText("3 meters");
                time.setText("1 minute away");
            case 5:
                dist.setText("5 meters");
                time.setText("3 minute away");
            case 6:
                dist.setText("7 meters");
                time.setText("5 minute away");
        }
    }
}
