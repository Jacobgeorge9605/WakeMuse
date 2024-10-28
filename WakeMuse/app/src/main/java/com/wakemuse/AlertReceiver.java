package com.wakemuse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import android.media.AudioManager;
import android.media.MediaPlayer;


public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String randomQuote = QuoteProvider.getRandomQuote();

        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
        
        // Use 'context' instead of 'this'
        final MediaPlayer mp = MediaPlayer.create(context, R.raw.high_volumering_tone);
        
        if (mp != null) {
            mp.start();
        }
    }
}