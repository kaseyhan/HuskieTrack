package com.example.rikit.shootermap;

import android.widget.TextView;

import java.security.spec.ECField;

public class TimerThread extends Thread {
    private int min;
    private int seconds;
    TimerThread() {
        min = 5;
        seconds = 0;
    }

    public void run() {
        if (min != 0 || seconds != 0) {
            if (seconds != 0) {
                seconds--;
            } else {
                min--;
                seconds = 59;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    public String timeToString(){
        String str = Integer.toString(min);
        str += ":";
        if(seconds < 10){
            str = str + "0" + Integer.toString(seconds);
        }
        else{
            str += Integer.toString(seconds);
        }
        return str;
    }
}
