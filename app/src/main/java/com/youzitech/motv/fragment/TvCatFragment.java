package com.youzitech.motv.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tvcat,container,false);

        mTvCatView = (RecyclerView) view.findViewById(R.id.tvCat_view);
        mTvCatView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        List<TvCategory> tvCateList = getTvCatList();
        mTvCatView.setAdapter(new TvCatAdapter(tvCateList));
        return view;
    }

    public static List<TvCategory> getTvCatList(){
        List<TvCategory> tv = new ArrayList<>();
        tv.add(new TvCategory("title1"));
        tv.add(new TvCategory("title2"));
        return tv;
    }

    private class TvCatHolder extends  RecyclerView.ViewHolder{

        private TextView textView;

        private TvCategory tvCategory;

        public TvCatHolder(LayoutInflater inflater,ViewGroup container) {
            super(inflater.inflate(R.layout.tvcat_item,container,false));
            textView = (TextView) itemView.findViewById(R.id.tvCat_view);
        }

        public void bindTvCategory(TvCategory category){
            this.tvCategory = category;
            textView.setText(tvCategory.getTitle());
        }
    }

    private class TvCatAdapter extends  RecyclerView.Adapter<TvCatHolder>{


        private List<TvCategory> tvCategories;

        public TvCatAdapter(List<TvCategory> tvCategories){
            tvCategories = tvCategories;
        }
        @Override
        public TvCatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new TvCatHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(TvCatHolder holder, int position) {
            TvCategory category = tvCategories.get(position);
            holder.bindTvCategory(category);
        }

        @Override
        public int getItemCount() {
            return null == tvCategories?0:tvCategories.size();
        }
    }
}
