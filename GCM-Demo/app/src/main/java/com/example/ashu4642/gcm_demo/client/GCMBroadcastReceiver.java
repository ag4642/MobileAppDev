package com.example.ashu4642.gcm_demo.client;

/**
 * Created by ashu4642 on 1/15/2015.
 */
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static com.example.ashu4642.gcm_demo.client.GCMConstants.DEFAULT_INTENT_SERVICE_CLASS_NAME;

/**
 * {@link BroadcastReceiver} that receives GCM messages and delivers them to
 * an application-specific {@link GCMBaseIntentService} subclass.
 * <p>
 * By default, the {@link GCMBaseIntentService} class belongs to the application
 * main package and is named
 * {@link GCMConstants#DEFAULT_INTENT_SERVICE_CLASS_NAME}. To use a new class,
 * the {@link #getGCMIntentServiceClassName(Context)} must be overridden.
 */
public class GCMBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "GCMBroadcastReceiver";

    @Override
    public final void onReceive(Context context, Intent intent) {
        Log.v(TAG, "onReceive: " + intent.getAction());
        String receiverClassName = getClass().getName();
        if (!receiverClassName.equals(GCMBroadcastReceiver.class.getName())) {
            GCMRegistrar.setRetryReceiverClassName(receiverClassName);
        }
        String className = getGCMIntentServiceClassName(context);
        Log.v(TAG, "GCM IntentService class: " + className);
        // Delegates to the application-specific intent service.
        GCMBaseIntentService.runIntentInService(context, intent, className);
        setResult(Activity.RESULT_OK, null /* data */, null /* extra */);
    }

    /**
     * Gets the class name of the intent service that will handle GCM messages.
     */
    protected String getGCMIntentServiceClassName(Context context) {
        return getDefaultIntentServiceClassName(context);
    }

    /**
     * Gets the default class name of the intent service that will handle GCM
     * messages.
     */
    static final String getDefaultIntentServiceClassName(Context context) {
        String className = context.getPackageName() +
                DEFAULT_INTENT_SERVICE_CLASS_NAME;
        return className;
    }
}
