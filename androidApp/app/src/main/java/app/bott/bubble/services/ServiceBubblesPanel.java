package app.bott.bubble.services;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;

import java.util.ArrayList;

import app.bott.bubble.bubbles.Bubble;

public class ServiceBubblesPanel extends Service {

    private final String TAG = "BUBBLE_CLASS";

    private static WindowManager windowManager;
    private static WindowManager.LayoutParams params;

    private static ArrayList<Bubble> bubbles = new ArrayList<>();


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "Service Create...");
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 100;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        for(Bubble actualBubble: bubbles)
             windowManager.removeView(actualBubble.getView());

        bubbles.clear();
    }

    protected static void addBubble(final Bubble  bubble){

        bubbles.add(bubble);
        windowManager.addView(bubble.getView(), params);

        /*
        bubble.getView().setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;


            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX
                                + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY
                                + (int) (event.getRawY() - initialTouchY);
                        windowManager.updateViewLayout(bubble.getView(), params);
                        return true;

                }
                return false;
            }
        });
        */

    }

    protected static void killBubble(Bubble bubble){

        for(Bubble actualBubble: bubbles)
            if(actualBubble.equals(bubble)) {

                windowManager.removeView(actualBubble.getView());
                bubbles.remove(bubble);

                break;
            }

    }


}
