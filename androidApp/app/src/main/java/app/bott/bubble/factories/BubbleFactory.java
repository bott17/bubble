package app.bott.bubble.factories;

import app.bott.bubble.bubbles.CircularBubble;

/**
 * Created by bott on 26/03/2015.
 */
public abstract class BubbleFactory {

    public CircularBubble createCircularBubble(){

        CircularBubble bubble = new CircularBubble();

        return  bubble;
    }
}
