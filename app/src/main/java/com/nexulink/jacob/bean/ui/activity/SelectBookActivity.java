package com.nexulink.jacob.bean.ui.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.nexuslink.www.googlefragment.R;

/**
 * Created by ASUS-NB on 2016/12/14.
 */

public class SelectBookActivity extends AppCompatActivity implements BookListFragment.CallBackListener{
    private static final String TAG = "SelectBookActivity";
    static OnSetHighLightListener lightListener;
    private boolean mTwoPane;
    public interface OnSetHighLightListener{
      void  setActivateOnItemClick(boolean activateOnItemClick);
    }
    public static void  setHighLightListener(OnSetHighLightListener onSetHighLight){
           lightListener = onSetHighLight;
        Log.e(TAG,"BookListFragment的setHighLightListener方法执行了");
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist_layout);
        Log.e(TAG,"BookListFragment的onCreate方法执行了");
        if(findViewById(R.id.details)!=null){
            Log.e(TAG,"这里崩 了吗？");
            mTwoPane = true;
        }
    }

    @Override
    public void onSelectedItem(int id) {
        /*
        现在都用newInstance来进行传递数据了.这种直接写在activity里面的方式似乎变少了.
         */
        if(mTwoPane){
        Bundle arguments = new Bundle();
        arguments.putInt(BookDetailsFragment.ITEM_ID,id);
        BookDetailsFragment fragment = new BookDetailsFragment();
        fragment.setArguments(arguments);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.details,fragment);
        ft.commit();
        lightListener.setActivateOnItemClick(true);
        Log.e(TAG,"BookListFragment的onSelectedItem方法执行了");}
        else {
            Intent intent = new Intent();
            intent.putExtra(BookDetailsFragment.ITEM_ID,id);
            intent.setClass(this,BookDetailActivity.class);
            startActivity(intent);
        }
    }
}
