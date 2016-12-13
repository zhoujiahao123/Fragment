package com.nexuslink.www.googlefragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;

/**
 * Created by ASUS-NB on 2016/12/13.
 */

public class TitlesFragment extends ListFragment {
    //判断fragment是否为空和是否为可视状态
    boolean mDualPane;
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item));
        //获取该fragment实例
        View detailsView = getActivity().findViewById(R.id.details);
        //获取当前的fragment实例是否为空并且是否可见
        mDualPane = detailsView!=null&&detailsView.getVisibility()==View.VISIBLE;
        //如果当之前保存了数据，从这里取出来.
        if(savedInstanceState!=null){
            mCurCheckPosition = savedInstanceState.getInt("curChoice",0);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存我们目前点击的位置
        outState.putInt("curChoice",mCurCheckPosition);
    }
    void showDetails(int index){
        mCurCheckPosition = index;

        if(mDualPane){
            //设置该item已经被选中了，
            getListView().setItemChecked(index,true);
            DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
        }
    }
}
