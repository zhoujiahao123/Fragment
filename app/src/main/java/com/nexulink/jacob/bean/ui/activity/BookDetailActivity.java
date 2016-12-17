package com.nexulink.jacob.bean.ui.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.nexuslink.www.googlefragment.R;

/**
 * Created by ASUS-NB on 2016/12/14.
 */

public class BookDetailActivity extends AppCompatActivity implements View.OnClickListener {
    BookDetailsFragment fragment;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bookdetail_layout);
        if(savedInstanceState==null){
             fragment=new BookDetailsFragment();
            Bundle arguments = new Bundle();
            arguments.putInt(BookDetailsFragment.ITEM_ID,getIntent().getIntExtra(BookDetailsFragment.ITEM_ID,0));
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .add(R.id.book_container,fragment)
                    .addToBackStack(null)
                    .commit();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.goback);
        toolbar.setNavigationOnClickListener(this);

}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}
