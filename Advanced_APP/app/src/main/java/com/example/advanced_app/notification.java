package com.example.advanced_app;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class notification extends AppCompatActivity
{

    Button notification;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notification = findViewById(R.id.btn_notification);

        notification.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                add_notification();
            }
        });
    }

    private void add_notification()
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.notification_icon).setContentTitle("Notification").setContentText("Android is working").setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent intent = new Intent(this,notification_display.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("message","set");

        PendingIntent pendingIntent = getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify('0',builder.build());

    }

}