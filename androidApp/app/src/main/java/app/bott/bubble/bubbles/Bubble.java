package app.bott.bubble.bubbles;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import app.bott.bubble.services.ServiceManager;

public class Bubble {

    private final String TAG = "BUBBLE_CLASS";

    protected View view;


    public Bubble(View bubbleView) {

        view = bubbleView;

    }

    public View getView() {
        return view;
    }

    public void makeActiveBubble(){
        ServiceManager.makeActiveBubble(this);
    }

    public void changeImage(Bitmap newImg, Context context) {
        ImageView img = new ImageView(context);
        img.setImageBitmap(newImg);

        view = img;
    }
}
