package teamsanguine.sanguine;


import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;

import junit.framework.TestCase;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Timmy on 10/5/2015.
 */
public class LocationTest extends ApplicationTest{

    static void sendLocation(double latitude, double longitude) {
        try {
            Socket socket = new Socket("10.0.2.2", 8617); // usually 5554
            socket.setKeepAlive(true);
            String str = "geo fix " + longitude + " " + latitude ;
            Writer w = new OutputStreamWriter(socket.getOutputStream());
            w.write(str + "\r\n");
            w.flush();
        }
        catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  void testGetLocation()
    {

        String testProvider = "Test1";
        LocationManager lm = (LocationManager) this.getContext().getSystemService(Context.LOCATION_SERVICE);
        if (null == lm.getProvider(testProvider)) {
            lm.addTestProvider(testProvider, false, false, false, false,
                    false, false, false, Criteria.POWER_LOW,
                    Criteria.ACCURACY_FINE);
        }

        GPSManager gm;
        double latitude;
        Location l = new Location(testProvider);
        l.setLatitude(0.0);
        l.setLongitude(0.0);
        l.setAccuracy(Criteria.ACCURACY_FINE);
        l.setTime(System.currentTimeMillis());
        l.setElapsedRealtimeNanos(10);
        l.setAccuracy(300);
        l.setAltitude(0);
        l.setSpeed(50);
        l.setBearing(0);
        lm.setTestProviderEnabled(testProvider, true);
        lm.setTestProviderStatus(testProvider, LocationProvider.AVAILABLE, null, System.currentTimeMillis());

        lm.setTestProviderLocation(testProvider, l);
        gm=new GPSManager(this.getContext());
        latitude=gm.getLatitude();

        assertEquals(l.getLatitude(), latitude);
        lm.removeTestProvider(testProvider);

    }




}
