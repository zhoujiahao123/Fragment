package com.nexulink.jacob.bean.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.nexuslink.www.googlefragment.R;

/**
 * Created by ASUS-NB on 2016/12/14.
 */

public class BookDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdetail_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(savedInstanceState==null){
            BookDetailsFragment fragment =new BookDetailsFragment();
            Bundle arguments = new Bundle();
            arguments.putInt(BookDetailsFragment.ITEM_ID,getIntent().getIntExtra(BookDetailsFragment.ITEM_ID,0));
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .add(R.id.book_container,fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
