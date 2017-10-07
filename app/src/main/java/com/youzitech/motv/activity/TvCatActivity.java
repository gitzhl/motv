package com.youzitech.motv.activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.youzitech.motv.R;
import com.youzitech.motv.fragment.TvCatFragment;
import com.youzitech.motv.fragment.TvRecentFragment;
import com.youzitech.motv.fragment.TvSettingsFragment;
import com.youzitech.motv.fragment.TvStarFragment;
import com.youzitech.motv.model.TvCategory;

import java.util.ArrayList;
import java.util.List;

public class TvCatActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if(fragment == null){
            fragment = new TvCatFragment();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }else{
            fm.beginTransaction().replace(R.id.fragment_container,fragment).commit();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.fragment_container);

            switch (item.getItemId()) {
                case R.id.navigation_tv:
                    if(fragment == null){
                        fm.beginTransaction().add(R.id.fragment_container,new TvCatFragment()).commit();
                    }else{
                        fm.beginTransaction().replace(R.id.fragment_container,new TvCatFragment()).commit();
                    }
                    return true;
                case R.id.navigation_recent:
                    if(fragment == null){
                        fragment = new TvRecentFragment();
                        fm.beginTransaction().add(R.id.fragment_container,new TvRecentFragment()).commit();
                    }else{
                        fm.beginTransaction().replace(R.id.fragment_container,new TvRecentFragment()).commit();
                    }
                    return true;
                case R.id.navigation_star:
                    if(fragment == null){
                        fm.beginTransaction().add(R.id.fragment_container,new TvStarFragment()).commit();
                    }else{
                        fm.beginTransaction().replace(R.id.fragment_container,new TvStarFragment()).commit();
                    }
                    return true;
                case R.id.navigation_settings:
                    if(fragment == null){
                        fm.beginTransaction().add(R.id.fragment_container, new TvSettingsFragment()).commit();
                    }else{
                        fm.beginTransaction().replace(R.id.fragment_container, new TvSettingsFragment()).commit();
                    }
                    return true;
            }
            return false;
        }

    };

}
