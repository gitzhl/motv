package com.youzitech.motv.activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import com.youzitech.motv.R;
import com.youzitech.motv.fragment.TvCatFragment;
import com.youzitech.motv.fragment.TvSettingsFragment;
import com.youzitech.motv.fragment.TvStarFragment;

/**
 * Created by Administrator on 2017/10/6 0006.
 */

public abstract  class SingleFragmentActivity extends FragmentActivity {

    protected  abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if(null == fragment){
            fragment =  createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.fragment_container);
            switch (item.getItemId()) {
                case R.id.navigation_tv:
                    if(null == fragment){
                        fragment =  new TvCatFragment();
                        fm.beginTransaction()
                                .add(R.id.fragment_container,fragment)
                                .commit();
                    }else{
                        fragment =  new TvCatFragment();
                        fm.beginTransaction()
                                .replace(R.id.fragment_container,fragment)
                                .commit();
                    }
                    return true;
                case R.id.navigation_star:
                    if(null == fragment){
                        fragment =  new TvStarFragment();
                        fm.beginTransaction()
                                .add(R.id.fragment_container,fragment)
                                .commit();
                    }else{
                        fragment =  new TvStarFragment();
                        fm.beginTransaction()
                                .replace(R.id.fragment_container,fragment)
                                .commit();
                    }
                    return true;
                case R.id.navigation_settings:
                    if(null == fragment){
                        fragment =  new TvSettingsFragment();
                        fm.beginTransaction()
                                .add(R.id.fragment_container,fragment)
                                .commit();
                    }else{
                        fragment =  new TvSettingsFragment();
                        fm.beginTransaction()
                                .replace(R.id.fragment_container,fragment)
                                .commit();
                    }
                    return true;
            }
            return false;
        }



    };
}
