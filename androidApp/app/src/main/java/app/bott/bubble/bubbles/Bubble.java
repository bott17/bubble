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

    protected View view;


    public Bubble(View bubbleView) {

        view = bubbleView;

    }

    public View getView() {
        return view;
    }
}
