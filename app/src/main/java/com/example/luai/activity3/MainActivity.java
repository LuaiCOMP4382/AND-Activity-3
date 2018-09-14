package com.example.luai.activity3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    // TODO (1): Define key string values for onCreate, onStart, onResume, onPause and onRestart
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = ...


    private static final String LIFECYCLE_CALLBACKS_TEXT_KEY = "callbacks";

    // TODO (2): Define show booleans for onCreate, onStart, onResume, onPause and onRestart with value "true"
    private static boolean showOnCreate = true;
    private static boolean showOnStart = ...


    private TextView mTextViewLifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewLifecycle = (TextView) findViewById(R.id.tv_lifecycle);


        if (savedInstanceState != null) {

            if (savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT_KEY)) {

                // TODO (8): Get the string from savedInstanceState with key LIFECYCLE_CALLBACKS_TEXT_KEY, and put it in mTextViewLifecycle

            }

        }

        setupSharedPreferences();

        if (showOnCreate)
            logAndAppend(ON_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // TODO (15): Finally, unregister the shared preferences on destroy
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(???);

    }

    @Override
    protected void onStart() {
        super.onStart();

        // TODO (3): Call logAndAppend only when showOnStart is true
        if (???)
            logAndAppend(???);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // TODO (4): Call logAndAppend only when showOnRestart is true

    }

    @Override
    protected void onPause() {
        super.onPause();

        // TODO (5): Call logAndAppend only when showOnPause is true
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        // TODO (6): Call logAndAppend only when showOnRestart is true
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        // TODO (7): Get the text of mTextViewLifecycle and put it to outState using the key LIFECYCLE_CALLBACKS_TEXT_KEY
        outState.putString(???, ???);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_settings:
                // TODO (9): Use an intent to start SettingsActivity


                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);

        mTextViewLifecycle.append(lifecycleEvent + "\n");
    }

    private void setupSharedPreferences() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // TODO (12): Get boolean values from sharedPreferences and set the 5 show boolean values
        showOnCreate = sharedPreferences.getBoolean(getString(R.string.pref_show_on_create), true);
        showOnStart = ...

        // TODO (14): Don't forget to register the OnSharedPreferenceChangeListener
        sharedPreferences.registerOnSharedPreferenceChangeListener(???);

    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        // TODO (13): Whenever the preference is changed, set the corresponding of the 5 boolean values to the new boolean value from the preference
        if (key.equals(getString(R.string.pref_show_on_create)))
            showOnCreate = sharedPreferences.getBoolean(getString(R.string.pref_show_on_create), true);
        else if (key.equals(getString(R.string.pref_show_on_start)))
            showOnStart = ...

    }
}
