package com.nexuslink.www.googlefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by ASUS-NB on 2016/12/13.
 */

public class DetailsFragment extends Fragment {
    public static DetailsFragment newInstance(int index){
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index",index);
        fragment.setArguments(args);
        return fragment;
    }
    public int getShownIndex(){
        return getArguments().getInt("index",0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(container==null){
            return null;
        }
        ScrollView scrollView = new ScrollView(getActivity());
        TextView tvDetail = new TextView(getActivity());
        //设置边距
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4,getActivity().getResources().getDisplayMetrics());
        tvDetail.setPadding(padding,padding,padding,padding);
        scrollView.addView(tvDetail);
        tvDetail.setText(getShownIndex());
        return scrollView;
    }
}
