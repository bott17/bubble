package app.bott.bubble.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import app.bott.bubble.bubbles.Bubble;
import app.bott.bubble.bubbles.CircularBubble;

/**
 * Created by bott on 26/03/2015.
 */
public abstract class ServiceManager {

    private static final String TAG = "SERVICE MANAGER";

    private static ComponentName serviceBubblesPanel;

    public static void startBubblesPanelService(Context cont){

        serviceBubblesPanel = cont.startService(new Intent(cont, ServiceBubblesPanel.class));

    }

    public static void stopBubblesPanelService(Context cont){

        boolean stop = cont.stopService(new Intent(cont, ServiceBubblesPanel.class));

        if (stop)
            Log.d(TAG, "ServiceBubblesPanel stop...");
        else
            Log.d(TAG, "ServiceBubblesPanel CANT stop...");

    }

    public static void addBubbleToPanel(Bubble bubble){
        ServiceBubblesPanel.addBubble(bubble);
    }


}
