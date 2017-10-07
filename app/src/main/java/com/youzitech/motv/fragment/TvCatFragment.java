package com.youzitech.motv.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.youzitech.motv.R;
import com.youzitech.motv.model.TvCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/28 0028.
 */

public class TvCatFragment extends Fragment {


    private RecyclerView mTvCatView;


    private List<TvCategory> tvCateList;

    private TvCatAdapter adapter;

    private void initData(){
        tvCateList = getTvCatList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tvcat,container,false);

        mTvCatView = (RecyclerView) view.findViewById(R.id.tvCat_view);
        mTvCatView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mTvCatView.addItemDecoration(new RecyclerView.ItemDecoration() {
        });
        tvCateList = getTvCatList();
        adapter = new TvCatAdapter(tvCateList);
        mTvCatView.setAdapter(adapter);
        return view;
    }


    public static List<TvCategory> getTvCatList(){
        List<TvCategory> tv = new ArrayList<>();
        tv.add(new TvCategory("title1"));
        tv.add(new TvCategory("title2"));
        tv.add(new TvCategory("title3"));
        tv.add(new TvCategory("title4"));
        tv.add(new TvCategory("title5"));
        tv.add(new TvCategory("title6"));
        tv.add(new TvCategory("title7"));
        tv.add(new TvCategory("title8"));
        return tv;
    }

    public static List<String> getListViewData(){
       List<String> data = new ArrayList<>();
        data.add("title1");
        data.add("title2");
        data.add("title3");
        return data;
    }

    private class TvCatHolder extends  RecyclerView.ViewHolder{

        private TextView textView;

        public TvCatHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }

    private class TvCatAdapter extends  RecyclerView.Adapter<TvCatHolder>{


        private List<TvCategory> mTvCategories;

        public TvCatAdapter(List<TvCategory> tvCategories){
            mTvCategories = tvCategories;
        }
        @Override
        public TvCatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(android.R.layout.simple_list_item_1,parent,false);
            return new TvCatHolder(view);
        }

        @Override
        public void onBindViewHolder(TvCatHolder holder, int position) {
            TvCategory category = mTvCategories.get(position);
            holder.textView.setText(category.getCategoryName());
        }

        @Override
        public int getItemCount() {
            return mTvCategories.size();
        }
    }
}
