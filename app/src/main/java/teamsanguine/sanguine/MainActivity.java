package teamsanguine.sanguine;

import android.app.Activity;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    GPSManager gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
       // int timeout = 4000; // make the activity visible for 4 seconds

       /* Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                finish();
                Intent homepage = new Intent(MainActivity.this, loginscreen.class);
                startActivity(homepage);
            }
        }, timeout);*/



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* gps = new GPSManager(MainActivity.this);
                // check if GPS enabled
                if(gps.canGetLocation()){

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings

                    Toast.makeText(getApplicationContext(), "Cant Access GPS" , Toast.LENGTH_LONG).show();
                    gps.showSettingsAlert();
                }*/



            }


        });

        Intent homepage = new Intent(MainActivity.this, loginscreen.class);
        startActivity(homepage);
        finish();
        //gps.stopUsingGPS();
    }



}
