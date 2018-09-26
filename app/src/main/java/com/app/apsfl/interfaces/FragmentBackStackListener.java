package com.app.apsfl.interfaces;

public interface FragmentBackStackListener {


    /*
    * Called when onBackPressed() is fired from an activity which holds fragments
    * Implement this interface in fragments and do the appropriate operations
    * Example : Saving the entered form details, Alert user if navigating back away from the form
    * */
    void onBackPressed();
}
