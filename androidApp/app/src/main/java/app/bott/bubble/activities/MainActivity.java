package app.bott.bubble.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import app.bott.bubble.R;
import app.bott.bubble.bubbles.Bubble;
import app.bott.bubble.bubbles.ChatHeadService;
import app.bott.bubble.factories.BubbleFactory;
import app.bott.bubble.services.ServiceManager;


public class MainActivity extends ActionBarActivity {

    private final String TAG = "MAIN_ACTIVITY_CLASS";

    Button createService, destroyService, newCircularBubble, openIMG;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();


    }




    private void initComponents(){

        img1 = (ImageView) findViewById(R.id.imageView);

        ChatHeadService ch = new ChatHeadService();

        Log.i("Main", "Init comp");

        createService = (Button) findViewById(R.id.button1);
        createService.setOnClickListener(new OnClickListener(

        ) {
            @Override
            public void onClick(View v) {
                //ChatHeadService ch = new ChatHeadService();
                //startService(new Intent(getApplicationContext(), ChatHeadService.class));
                //Bubble b =  new CircularBubble();
                //b.startBubbleService(getApplicationContext(), b.getClass());
                //startService(new Intent(getApplicationContext(),CircularBubble.class));

                ServiceManager.startBubblesPanelService(getApplicationContext());

            }
        });

        destroyService = (Button) findViewById(R.id.button2);
        destroyService.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceManager.stopBubblesPanelService(getApplicationContext());
            }
        });

        newCircularBubble = (Button) findViewById(R.id.button3);
        newCircularBubble.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bubble b = BubbleFactory.createCircularBubble(getApplicationContext());
                //ServiceManager.addBubbleToPanel(b);

                Intent circularBubbleIntent = new Intent(getApplicationContext(), BubbleOptionsActivity.class);
                circularBubbleIntent.putExtra("BubbleCode", b.g);
                startActivity(new Intent(getApplicationContext(), BubbleOptionsActivity.class));
            }
        });

        openIMG = (Button) findViewById(R.id.button4);
        openIMG.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "bun1");

                Intent gallIntent=new Intent(Intent.ACTION_GET_CONTENT);
                gallIntent.setType("image/*");

                List<Intent> yourIntentsList = new ArrayList<Intent>();
                PackageManager packageManager = getApplicationContext().getPackageManager();
                List<ResolveInfo> listGall = packageManager.queryIntentActivities(gallIntent, 0);

                Log.d(TAG, "List of intents size: " + listGall.size());


                Intent picMessageIntent = new Intent(Intent.ACTION_GET_CONTENT);
                picMessageIntent.setType("image/*");

                //startActivity(Intent.createChooser(picMessageIntent, "Send your picture using:"));
                //startActivity(picMessageIntent);
                startActivityForResult(picMessageIntent, 555);



                //Intent intent = new Intent(Intent.ACTION_PICK,
                  //      android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //startActivityForResult(intent, 0);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
