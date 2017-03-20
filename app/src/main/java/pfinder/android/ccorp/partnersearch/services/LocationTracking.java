package pfinder.android.ccorp.partnersearch.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by rajkumar on 3/15/17.
 */

public class LocationTracking extends Service {

    private static final String TAG=LocationTracking.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG,"My OnCreate ::: "+Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.v(TAG,"My OnStatCommand ::: "+Thread.currentThread().getName());
        // communicate LocationManeger to track the Lat & Lon position

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
