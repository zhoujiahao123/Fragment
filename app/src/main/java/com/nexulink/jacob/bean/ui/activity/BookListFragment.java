package com.nexulink.jacob.bean.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nexulink.jacob.bean.BookContent;

/**
 * Created by ASUS-NB on 2016/12/14.
 * 继承至ListFragment的子类实现onCreateView，因为会在onCreateView中默认的返回一个ListView.
 * 而是只需要实现ListFragment中的setAdapter方法为该Fragment设置Adapter即可.
 */

public class BookListFragment extends ListFragment{
    private static final String TAG="ListFragment";
    private CallBackListener listener;

    /**
     *通过定义的这个接口来传递数据给activity
     */
    public interface CallBackListener{
         void onSelectedItem(int id);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"BookListFragment的onCreate方法执行了");
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(),android.R.layout.simple_list_item_activated_1,android.R.id.text1,BookContent.ITEMS));
        SelectBookActivity.setHighLightListener(new SelectBookActivity.OnSetHighLightListener() {
            @Override
            public void setActivateOnItemClick(boolean activateOnItemClick) {
                getListView().setChoiceMode(activateOnItemClick?ListView.CHOICE_MODE_SINGLE:ListView.CHOICE_MODE_NONE);
                Log.e(TAG,"setActivateOnItemClick执行了");
            }
        });
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG,"BookListFragment的onAttach方法执行了");
        if(!(context instanceof CallBackListener)){
            throw new IllegalStateException("activity必须实现CallBackListener接口");
        }
        else{
            listener = (CallBackListener)context;

        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        //这里为什么要将他赋值为null?
        listener = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        listener.onSelectedItem(BookContent.ITEMS.get(position).id);
        Log.e(TAG,"BookListFragment的onListItemClick方法执行了");
    }
}
