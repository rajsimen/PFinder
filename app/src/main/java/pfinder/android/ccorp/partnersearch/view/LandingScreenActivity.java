package pfinder.android.ccorp.partnersearch.view;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;

import pfinder.android.ccorp.partnersearch.R;
import pfinder.android.ccorp.partnersearch.model.Constants;
import pfinder.android.ccorp.partnersearch.services.GPSLocationTracking;
import pfinder.android.ccorp.partnersearch.services.GetMyCurrentLocationService;

/**
 * Created by rajkumar on 3/15/17.
 */

public class LandingScreenActivity  extends AppCompatActivity
        {

    private static final int MY_PERMISSION_ACCESS_COARSE_LOCATION = 11;
    private static final String TAG=LandingScreenActivity.class.getSimpleName();
    private AddressResultReceiver mResultReceiver;
    protected Location mLastLocation;
    private GoogleApiClient mGoogleApiClient=null;
    private boolean mAddressRequested=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);

        Log.i(TAG,"My onCreate"+Thread.currentThread().getName());
        /*mResultReceiver=new AddressResultReceiver(null);
        startGetMyCurrentLocationService();*/

        /*Intent gpsIntent=new Intent(getApplicationContext(), GPSLocationTracking.class);
        gpsIntent.putExtra("message","Message From Activity");
        startService(gpsIntent);*/





        /*FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_wrapper, new GoogleMapViewFragment());
        fragmentTransaction.commit();*/





    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"pfinder:: onPause"+Thread.currentThread().getName());

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"pfinder:: onStart"+Thread.currentThread().getName());


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"pfinder:: onStop"+Thread.currentThread().getName());
        Intent gpsIntent=new Intent(getApplicationContext(), GPSLocationTracking.class);
        stopService(gpsIntent);
    }




    public class AddressResultReceiver extends ResultReceiver{

        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);

            if (resultCode==Constants.SUCCESS_RESULT && resultData!=null){
                String address=resultData.getString(Constants.RESULT_DATA_KEY);
                Log.i(TAG,"Current Address:::"+address);
                Log.i(Constants.LATITUDE,resultData.getString(Constants.LATITUDE));
            }
        }
    }



    private void startGetMyCurrentLocationService(){
        Intent locationTracingServiceIntent=new Intent(getApplicationContext(), GetMyCurrentLocationService.class);
        locationTracingServiceIntent.putExtra(Constants.RECEIVER, mResultReceiver);

        startService(locationTracingServiceIntent);
    }
}
