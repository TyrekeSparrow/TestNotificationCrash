package com.example.michael.testnotificationcrash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by michael on 17-1-26.
 */

public class NotificationDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView imageView = (ImageView) findViewById(R.id.detail_image_view);

        // throw new NullPointerException();
//        savedInstanceState.get("");

        Intent intent = getIntent();
        if (intent != null) {
            Log.d("notificationCrash", "intent not null ...");
            Bundle bundle = intent.getBundleExtra("bundle");
            if (bundle != null) {
                int resId = bundle.getInt("resId");
                Log.d("notificationCrash", "NotificationDetailActivity bundle resId = " + resId);
                Log.d("notificationCrash", "NotificationDetailActivity notify_clean_logo_smallxxx resId = " + R.drawable.notify_clean_logo_smallxxx);
//                resId++;
                // 0x7f020035
//                resId = 0x7f0c0034;
                int a = 1;
                int b = 2;
                resId = a + b;
                Log.d("notificationCrash", "notify_clean_logo_smallxxx resId = " + resId);
                imageView.setImageResource(resId);
            }
        } else {
            Log.d("notificationCrash", "intent null !!!");
        }
    }
}
