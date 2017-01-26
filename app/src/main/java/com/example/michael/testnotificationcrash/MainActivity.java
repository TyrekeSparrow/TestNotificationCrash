package com.example.michael.testnotificationcrash;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void postNotification(View view) {
        showNotification(this);
    }

    private static final int NOTIFICATION_ID = 16;

    private static void showNotification(Context context) {
        Log.d("notificationCrash", "showNotification");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_apus);
        // public void setImageResource(int resId) {

        Log.d("notificationCrash", "notification image src resId = " + R.drawable.notify_clean_logo_smallxxx);
        /*
        Bundle bundle = new Bundle();
        bundle.putInt("resId", R.drawable.notify_clean_logo_smallxxx);
        remoteViews.setBundle(R.id.image_view, "setImageResource", bundle);
        */

        /*
        String methodName = "setImageResource";
        int viewId = R.id.image_view;
        int value = R.drawable.notify_clean_logo_smallxxx;
        remoteViews.setInt(viewId, methodName, value);
        */

        Intent intent = new Intent(context, NotificationDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle = new Bundle();
        bundle.putInt("resId", R.drawable.notify_clean_logo_smallxxx);
        intent.putExtra("bundle", bundle);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.text_view, pendingIntent);

        int a = 1;
        int b = 2;
        int resIddd = a + b;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle("notificationTitleAPUS")
                .setContentText("notificationTextApus")
//                .setSmallIcon(R.drawable.notify_clean_logo_smallxxx)
                .setSmallIcon(resIddd)
//                .setSmallIcon(R.drawable.china)
//                .setLargeIcon(largeIcon)
//                .setPriority(NotificationCompat.PRIORITY_MIN)
//                .setOngoing(true)
                .setContent(remoteViews)
//                .setColor(0x00000000)
                ;
        Notification notification = builder.build();

//        notification.contentView = remoteViews;
//        notification.flags = Notification.FLAG_NO_CLEAR;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
//        sleep();
//        Log.d("notificationCrash", "notification = " + notification);
    }

    public void getDisplay(View view) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        int densityDpi = displayMetrics.densityDpi;
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        Log.d("notificationCrash", "density = " + density);
        Log.d("notificationCrash", "densityDpi = " + densityDpi);
        Log.d("notificationCrash", "widthPixels = " + widthPixels);
        Log.d("notificationCrash", "heightPixels = " + heightPixels);
    }

    public static void sleep() {
        Log.d("notificationCrash", "sleep 6s");

        try {
            Thread.sleep(6 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testDensity(View view) {
        Drawable drawable = getResources().getDrawable(R.drawable.feedback);
        if (drawable != null) {
            Log.d("notificationCrash", "feedback drawable not null = " + drawable);
        } else {
            Log.d("notificationCrash", "feedback drawable null = " + drawable);
        }



    }
}
