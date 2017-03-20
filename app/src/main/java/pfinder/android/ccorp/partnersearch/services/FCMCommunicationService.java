package pfinder.android.ccorp.partnersearch.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by rajkumar on 3/15/17.
 */

public class FCMCommunicationService extends IntentService {
    private static final String TAG=FCMCommunicationService.class.getSimpleName();

    public FCMCommunicationService() {
        super(TAG+"Worker Thread");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG,"My OnCreate ::: "+Thread.currentThread().getName());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG,"My onBind"+Thread.currentThread().getName());
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.v(TAG,"My onHandleIntent"+Thread.currentThread().getName());
    }
}
