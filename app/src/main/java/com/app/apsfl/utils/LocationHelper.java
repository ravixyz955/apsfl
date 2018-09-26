package com.app.apsfl.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

public class LocationHelper implements LocationListener {

    private static final String TAG = "LocationHelper";
    private LocationManager locationManager;
    private static LocationHelper mLocationHelper;
    private onLocationUpdate mLocationListener;

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 10 * 1000;

    public interface onLocationUpdate {
        void onLocationChange(Location location);
    }


    private LocationHelper() {

    }

    public static LocationHelper getInstance() {
        if (mLocationHelper == null) {
            mLocationHelper = new LocationHelper();
        }
        return mLocationHelper;
    }

    public boolean init(Context mContext, onLocationUpdate locationListener) {
        Log.d(TAG, "\t" + "initLocationHelper");
        boolean isLocationEnabled;
        if (locationListener != null) {
            mLocationListener = locationListener;
        }
        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        Log.d("isGPSEnabled  ->  ", String.valueOf(isGPSEnabled));
        Log.d("isNetworkEnabled  ->  ", String.valueOf(isNetworkEnabled));
      /*  if (isGPSEnabled) {
            isLocationEnabled = true;
            Log.d("GPS ->", "Enabled");
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.d("Permission  ->  ", "Granted");
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                        MIN_TIME_BW_UPDATES, 0, this);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    mLocationListener.onLocationChange(location);
                }
            } else {
                Log.d("Permission  ->  ", "Denied");
            }
        } else*/ if (isNetworkEnabled) {
            isLocationEnabled = true;
            Log.d("Network ->", "Enabled");
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.d("Permission  ->  ", "Granted");
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                        MIN_TIME_BW_UPDATES, 0, this);
                Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if (location != null) {
                    mLocationListener.onLocationChange(location);
                }
            } else {
                Log.d("Permission  ->  ", "Denied");
            }
        } else if (isGPSEnabled) {
            isLocationEnabled = true;
            Log.d("GPS ->", "Enabled");
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.d("Permission  ->  ", "Granted");
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                        MIN_TIME_BW_UPDATES, 0, this);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    mLocationListener.onLocationChange(location);
                }
            } else {
                Log.d("Permission  ->  ", "Denied");
            }
        }
        else {
            isLocationEnabled = false;
            Log.d("Location ->", "Turned OFF");
        }
        return isLocationEnabled;
    }

    public void removeLocationUpdates(Context mContext) {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "\t" + "Removing Location Listener");
            locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
            locationManager.removeUpdates(this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null && mLocationListener != null) {
            mLocationListener.onLocationChange(location);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d(TAG, "onLocationStatusChanged");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d(TAG, "onProviderEnabled ->  " + provider);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d(TAG, "onProviderDisabled ->  " + provider);
    }
}