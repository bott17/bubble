package app.bott.bubble.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;

import app.bott.bubble.R;
import app.bott.bubble.bubbles.Bubble;
import app.bott.bubble.factories.BubbleFactory;
import app.bott.bubble.services.ServiceManager;

public class BubbleOptionsActivity extends ActionBarActivity {

    private static final String TAG = "BubbleOptionsActivity";

    private Button buttonSelectIMG;
    private Bubble bubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_options);

        initComponents();
        createBubble();
    }

    private void initComponents(){

        buttonSelectIMG = (Button) findViewById(R.id.button4);
        buttonSelectIMG..setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "Abriendo selector de galerias...");

                Intent mediaIntent = new Intent(Intent.ACTION_GET_CONTENT);
                mediaIntent.setType("image/*");
                startActivityForResult(mediaIntent, 555);
            }
        });
    }

    private void createBubble(){
        Bubble b = BubbleFactory.createCircularBubble(getApplicationContext());
        ServiceManager.addBubbleToPanel(b);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 555){
            Uri targetUri = data.getData();
            // textTargetUri.setText(targetUri.toString());
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                img1.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bubble_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
