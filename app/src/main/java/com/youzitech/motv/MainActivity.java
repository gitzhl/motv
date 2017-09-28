package com.youzitech.motv;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.transition.Transition;
import android.view.MenuItem;
import android.widget.TextView;

import com.youzitech.motv.fragment.TvCatFragment;
import com.youzitech.motv.fragment.TvSettingsFragment;
import com.youzitech.motv.fragment.TvStarFragment;

public class MainActivity extends Activity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_tv:
                    TvCatFragment tvCatFragment = new TvCatFragment();
                    android.app.FragmentManager manager = getFragmentManager();
                    FragmentTransaction transition = manager.beginTransaction();
                    transition.replace(R.id.fragment_cat,tvCatFragment);
                    transition.commit();
                    return true;
                case R.id.navigation_star:
                    TvStarFragment tvStarFragment = new TvStarFragment();
                    android.app.FragmentManager starManager = getFragmentManager();
                    FragmentTransaction starTransition = starManager.beginTransaction();
                    starTransition.replace(R.id.fragment_cat,tvStarFragment);
                    starTransition.commit();
                    return true;
                case R.id.navigation_settings:
                    TvSettingsFragment tvSettingsFragment = new TvSettingsFragment();
                    android.app.FragmentManager settingsManager = getFragmentManager();
                    FragmentTransaction settingsTransition = settingsManager.beginTransaction();
                    settingsTransition.replace(R.id.fragment_cat,tvSettingsFragment);
                    settingsTransition.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TvCatFragment tvCatFragment = new TvCatFragment();
        android.app.FragmentManager manager = getFragmentManager();
        FragmentTransaction transition = manager.beginTransaction();
        transition.replace(R.id.fragment_cat,tvCatFragment);
        transition.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
