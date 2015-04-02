package app.bott.bubble.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;

import java.util.ArrayList;

import app.bott.bubble.R;
import app.bott.bubble.activities.MainActivity;
import app.bott.bubble.bubbles.Bubble;

public class ServiceBubblesPanel extends Service {

    private static final String TAG = "SERVICE_PANEL_BUBBLES";

    private static WindowManager windowManager;
    private static WindowManager.LayoutParams params;

    private static ArrayList<Bubble> bubbles = new ArrayList<>();
    private static Bubble activeBubble = null;

    protected static Bubble getActiveBubble() {
        Log.d(TAG, activeBubble.toString());
        return activeBubble;
    }

    public static WindowManager.LayoutParams getParams() {
        return params;
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "Service Create...");
        super.onCreate();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "Service Start...");

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
//        params.x = 0;
//        params.y = 100;


        Intent nextIntent = new Intent(this, MainActivity.class);
        nextIntent.setAction("hola");
        PendingIntent pnextIntent = PendingIntent.getService(this, 0,
                nextIntent, 0);
        Notification notification = new Notification.Builder(getApplicationContext()).build();
        startForeground(1, notification);


        return START_STICKY;
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
        params.x = bubble.getPosX();
        params.y = bubble.getPosY();
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


    protected static void makeActiveBubble(Bubble thisBubble) {
        activeBubble = thisBubble;
    }

    protected static void cleanActiveBubble(){ activeBubble = null;}

    public static void moveBubble(Bubble bubble) {

        params.x = bubble.getPosX();
        params.y = bubble.getPosY();

        windowManager.updateViewLayout(bubble.getView(), params);
    }
}
