package edu.uci.seal.myweather;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LocationListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            //register a callback
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 4000, 0, this);
        }catch(SecurityException e){
        }
    }
    public void updateLocation(double longitude,  double latitude){
        Log.i("MyWeather", "start service with "+longitude);
        Intent intent = new Intent();
        intent.setAction("edu.uci.seal.action.UPDATE_LOCATION");
        intent.putExtra("LONG", longitude);
        intent.putExtra("LAT", latitude);
        startService(intent);
    }
    //LocationListener methods
    @Override
    public void onLocationChanged(Location location) {
        updateLocation(location.getLongitude(), location.getLatitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
