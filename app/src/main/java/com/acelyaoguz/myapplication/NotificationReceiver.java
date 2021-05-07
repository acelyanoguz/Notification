package com.acelyaoguz.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class NotificationReceiver extends BroadcastReceiver {
    private String channelId = "CHANNEL_ID";
    private String channelName = "CHANNEL_NAME";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent notificationIntent = new Intent(context, ResultActivity.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //Bildirim servisi aktivasyonu
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    channelName,
                    importance
            );
            channel.setShowBadge(true);
            channel.enableVibration(true);
            channel.enableLights(true);
            if(notificationManager != null)
                notificationManager.createNotificationChannel(channel);
        }


        //Bildirim yapısı
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new Notification.Builder(context, channelId);
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Notification Uygulaması");
        builder.setContentText("Yeni bildirim var");
        builder.setContentIntent(pendingIntent);

        //Bildirimin gönderilmesi
        if(notificationManager != null)
            notificationManager.notify(0, builder.build());

    }

}
