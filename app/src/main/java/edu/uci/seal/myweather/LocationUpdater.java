package edu.uci.seal.myweather;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class LocationUpdater extends Service {
    public LocationUpdater() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        double longitude = intent.getDoubleExtra("LONG", 0);
        double latitude = intent.getDoubleExtra("LAT", 0);
        //fetch the weather forecast for this location
        //update the database and/or the widget with the new location
        Log.i("MyWEATHER", "location "+longitude+" "+latitude);
        return START_STICKY;
    }

}
