package com.youzitech.motv.activity;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.youzitech.motv.fragment.TvCatFragment;

public class MainActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new TvCatFragment();
    }

    public static void newIntent(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);

    }
}
