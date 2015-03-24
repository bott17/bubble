package app.bott.bubble;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity {

    Button newBubbleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();


    }




    private void initComponents(){

        ChatHeadService ch = new ChatHeadService();

        newBubbleButton = (Button) findViewById(R.id.button1);
        newBubbleButton.setOnClickListener(new OnClickListener(

        ) {
            @Override
            public void onClick(View v) {
                ChatHeadService ch = new ChatHeadService();
                startService(new Intent(getApplicationContext(), ChatHeadService.class));
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
