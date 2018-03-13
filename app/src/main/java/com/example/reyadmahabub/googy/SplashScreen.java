package com.example.reyadmahabub.googy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
private final int Splash_screen_time=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash_screen );
         new Thread( new Runnable() {
             @Override
             public void run() {
                 synchronized (this){
                     try {
                         wait(Splash_screen_time);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }finally {
                         startActivity( new Intent( SplashScreen.this,MainActivity.class ) );
                         finish();
                     }
                 }

             }
         } ).start();

    }
}
