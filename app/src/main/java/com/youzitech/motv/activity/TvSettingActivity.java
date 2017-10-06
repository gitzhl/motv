package com.youzitech.motv.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.youzitech.motv.fragment.TvSettingsFragment;

/**
 * Created by Administrator on 2017/10/6 0006.
 */

public class TvSettingActivity extends  SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new TvSettingsFragment();
    }

    public static void newIntent(Context context){
        Intent intent = new Intent(context,TvSettingActivity.class);
        context.startActivity(intent);

    }
}
