package com.nexulink.jacob.bean.ui.activity;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nexulink.jacob.bean.BookContent;
import com.nexuslink.www.googlefragment.R;

/**
 * Created by ASUS-NB on 2016/12/14.
 * 疑问，为何不能是app中的Fragment   因为android.support.v4.app版本主要是用来支持低版本。最低可以兼容到1.6,当使用这个版本的时候
 * 获取fragmentManager的方法为getSupportFragmentManager
 * 注意：使用的fragment的包需要统一。不然会出错
 */

public class BookDetailsFragment extends Fragment {
    public static final String ITEM_ID = "item_id";
    private static final String TAG = "BookDetailsFragment";
    public BookContent.Book book;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //判断activity是否通过
        if(getArguments().containsKey(ITEM_ID)){
            book = BookContent.ITEMS_MAP.get(getArguments().getInt(ITEM_ID));
            Log.e(TAG,"onCreate执行了");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreate5执行了");
        View rootView = inflater.inflate(R.layout.fragment_details_layout,container,false);
        Log.e(TAG,"onCreate1执行了");
        ((TextView)rootView.findViewById(R.id.title)).setText(book.titles);
        Log.e(TAG,"onCreate2执行了");
        ((TextView)rootView.findViewById(R.id.content)).setText(book.content);
        Log.e(TAG,"onCreate3执行了");
        return rootView;
    }
}
