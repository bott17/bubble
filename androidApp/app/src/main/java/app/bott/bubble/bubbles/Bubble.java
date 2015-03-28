package app.bott.bubble.bubbles;

import android.view.View;

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
