package com.example.wearosnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.wearosnotification.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
         NotificationChannel notificationChannel = new NotificationChannel("defult","test",NotificationManager.IMPORTANCE_DEFAULT);
         manager.createNotificationChannel(notificationChannel);
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);


         Notification.Builder builder = new Notification.Builder(this,"defult")
                 .setContentTitle("hello There")
                 .setContentText("How are you Doing?")
                 .setSmallIcon(android.R.drawable.arrow_up_float)
                 .setContentIntent(pendingIntent);

         manager.notify(0,builder.build());





        mTextView = binding.text;

    }
}