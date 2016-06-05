package com.gcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;

public class gcmlistner extends GcmListenerService {
    Context ctx;
    @Override
    public void onMessageReceived(String from, Bundle data) {
        ctx = getApplicationContext();
        Intent notificationIntent = new Intent(ctx, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(ctx,
                8000, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager nm = (NotificationManager) ctx
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(ctx);

        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentTitle(data.getString("title"))
                .setContentText(data.getString("message"));
        Notification n = builder.build();

        nm.notify(100, n);
    }

}
