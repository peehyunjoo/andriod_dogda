package com.example.dogda;

import android.app.Activity;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class BackPressCloseHandler {
    private long backKeyPresseedTime = 0;
    private Toast toast;

    private Activity activity;

    public BackPressCloseHandler(Activity context){
        this.activity = context;
    }

    public void onBackPressed(){
        if(System.currentTimeMillis() > backKeyPresseedTime + 2000 ){
            backKeyPresseedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if(System.currentTimeMillis() <= backKeyPresseedTime + 2000){
            activity.finish();
            toast.cancel();
        }
    }

    public void showGuide(){
        toast = Toast.makeText(activity,"종료됩니다", LENGTH_SHORT);
        toast.show();
    }
}
