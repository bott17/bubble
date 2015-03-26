package app.bott.bubble.bubbles;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;

import app.bott.bubble.R;

public class Bubble {

    private final String TAG = "BUBBLE_CLASS";

    protected ImageView bubble;

/*
    public Bubble(ImageView _bubble_) {
        this.bubble = _bubble_;

        initBubble();
    }*/


    private void initBubble(){



        bubble.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                Log.d(TAG, "Entering onLongClick");
                //windowManager.removeView(bubble);

                //if(bubbleClass != null)
                   // stopService(new Intent(getApplicationContext(), bubbleClass));

               // else
                //    Log.e(TAG, "Bubble class not defined---");

                return true;
            }
        });


        /*
        bubble.setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "Entering onClick");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "Entering onClick - case1");
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "Entering onClick - case2");
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "Entering onClick - case3");
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        windowManager.updateViewLayout(bubble, params);
                        return true;
                    default:
                        Log.d(TAG, "Entering onClick - default");
                        return false;
                }
            }
        });
        */
    }
}
