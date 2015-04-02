package app.bott.bubble.bubbles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.bott.bubble.services.ServiceManager;

public class Bubble {

    private final String TAG = "BUBBLE_CLASS";

    protected int posX, posY;
    protected View view;


    public Bubble(View bubbleView) {

        view = bubbleView;
        posX=0;
        posY=100;

    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public View getView() {
        return view;
    }

    public void makeActiveBubble(){
        ServiceManager.makeActiveBubble(this);
    }

    public void changeImage(Drawable newImg, Context context) {
        ImageView img = new ImageView(context);
        //img.setImageBitmap(newImg);
        img.setImageDrawable(newImg);

        view = img;
    }

    public void setNewPos(int newX, int newY) {
        posX = newX;
        posY = newY;
    }
}
