package com.example.michael.testnotificationcrash;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
        /*
        final int resId = R.drawable.notify_clean_logo_smallxxx - 100;
        postNotification(this, resId);
        */
    }

    private static final int NOTIFICATION_ID = 16;

    private static void postNotification(Context context, int resId) {
        Log.d("notificationCrash", "postNotification");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_apus);
        // public void setImageResource(int resId) {

//        Log.d("notificationCrash", "postNotification notification image src resId = " + R.drawable.notify_clean_logo_smallxxx);
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

        /*
        int resId = R.drawable.notify_clean_logo_smallxxx;
        resId = resId - 100;
        */

        /*
        int a = 1;
        int b = 2;
        int resIddd = a + b;
        */


        Log.d("notificationCrash", "postNotification resIdHex = " + Integer.toHexString(resId));

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle("notificationTitleAPUS")
                .setContentText("notificationTextApus")
                .setSmallIcon(resId)

//                .setSmallIcon(resIddd)
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

        Log.d("notificationCrash", "before try notificationManager.notify");
        try {
            Log.d("notificationCrash", "in try notificationManager.notify");
            notificationManager.notify(NOTIFICATION_ID, notification);
            Log.d("notificationCrash", "after try notificationManager.notify");
//            android.app.RemoteServiceException: Bad notification posted from package com.example.michael.testnotificationcrash: Couldn't create icon: StatusBarIcon(pkg=com.example.michael.testnotificationcrashuser=0 id=0x7f020038 level=0 visible=true num=0 )
        } catch (Exception e) {
            Log.d("notificationCrash", "catch RemoteServiceException success!!!!!!!!");
        }
        Log.d("notificationCrash", "after catch notificationManager.notify");

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

    public void delayPostNotification(View view) {
//        final int resId = R.drawable.notify_clean_logo_smallxxx;

        // TODO resId my be referent res none, then crash

        int a = 1;
        int b = 2;
        final int resId = a + b;

        Log.d("notificationCrash", "delayPostNotification before post resIdHex = " + Integer.toHexString(resId));

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.d("notificationCrash", "delayPostNotification post run resIdHex = " + Integer.toHexString(resId));
                Log.d("notificationCrash", "delayPostNotification post run current resIdHex = " + Integer.toHexString(R.drawable.notify_clean_logo_smallxxx));
                postNotification(MainActivity.this, resId);
            }
        };
        long delayMillis = 3 * 1000;
        new Handler(Looper.getMainLooper()).postDelayed(runnable, delayMillis);
    }
}
