package app.bott.bubble.factories;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import app.bott.bubble.R;
import app.bott.bubble.bubbles.CircularBubble;
import app.bott.bubble.services.ServiceManager;

/**
 * Created by bott on 26/03/2015.
 */
public abstract class BubbleFactory {

    public static CircularBubble createCircularBubble(Context context){

        ImageView img = new ImageView(context);
        img.setImageResource(R.drawable.ic_launcher);

        final CircularBubble bubble = new CircularBubble(img);

        bubble.getView().setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                ServiceManager.removeBubbleFromPanel(bubble);
                return true;
            }
        });

        return  bubble;
    }
}
