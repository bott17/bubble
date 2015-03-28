package app.bott.bubble.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import app.bott.bubble.bubbles.Bubble;

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

        if (stop) {
            Log.d(TAG, "ServiceBubblesPanel stop...");
            serviceBubblesPanel = null;
        }
        else
            Log.d(TAG, "ServiceBubblesPanel CANT stop...");

    }

    public static void addBubbleToPanel(Bubble bubble){
        if(serviceBubblesPanel != null)
            ServiceBubblesPanel.addBubble(bubble);
        else
            Log.d(TAG, "CANT add bubbble to panel, service not up....");
    }

    public static void removeBubbleFromPanel(Bubble bubble){
        ServiceBubblesPanel.killBubble(bubble);
    }


}
