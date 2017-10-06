package com.youzitech.motv.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.youzitech.motv.fragment.TvCatFragment;

/**
 * Created by Administrator on 2017/10/6 0006.
 */

public class TvStarActivity extends  SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new TvCatFragment();
    }

    public static void newIntent(Context context){
        Intent intent = new Intent(context,TvStarActivity.class);
        context.startActivity(intent);

    }
}
