package com.example.delivery.Helper;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.delivery.R;

public class NotificationHelper extends ContextWrapper {

    private static final String DTH_CHANEL_ID = "com.example.delivery";
    private static final String DTH_CHANEL_NAME = "Delivery";

    private NotificationManager manager;
    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            createChanel();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChanel() {
        NotificationChannel channel = new NotificationChannel(DTH_CHANEL_ID, DTH_CHANEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableLights(false);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if(manager == null)
            manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getDeliveryChannelNotification(String title, String body, PendingIntent cPendingIntent, Uri soundUri)
    {
        return new Notification.Builder(getApplicationContext(), DTH_CHANEL_ID)
                .setContentIntent(cPendingIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_baseline_local_shipping_24)
                .setSound(soundUri)
                .setAutoCancel(false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getDeliveryChannelNotification(String title, String body, Uri soundUri) {
        return new Notification.Builder(getApplicationContext(), DTH_CHANEL_ID)
                .setContentText(body)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_baseline_local_shipping_24)
                .setAutoCancel(false)
                .setSound(soundUri);
    }
}
