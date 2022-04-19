package com.prince.testapplication;

import static android.content.ContentValues.TAG;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.LongDef;

public class ApplicationClass extends Application {

    private static Context applicationContext;
    private Handler handler  = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;

        Log.d(TAG, "onCreate: inside application class  Context = "+ applicationContext);

        new Thread(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG, "run:  background thread instantiated");

                handler.postDelayed(this, 1000);
            }
        }).start();
    }

    public  Context getApplicationCnxt(){
        return applicationContext;

    }

    public void getWarningToast(){
        Log.d(TAG, "getWarningToast: from the Application class");
    }


}
