package app.bott.bubble.bubbles;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import app.bott.bubble.R;

/**
 * Created by bott on 26/03/2015.
 */
public class CircularBubble  extends Bubble{

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("CircularBubble", "Oncreate Bubble");

        bubbleClass = CircularBubble.class;

        bubble.setImageResource(R.drawable.ic_launcher);
        windowManager.addView(bubble, params);

    }



}
