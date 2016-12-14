package com.nexulink.jacob.bean.app;

import android.app.Application;

import com.antfortune.freeline.FreelineCore;

/**
 * Created by ASUS-NB on 2016/12/14.
 */

public class App extends Application {
    public void onCreate() {
        super.onCreate();
        FreelineCore.init(this);
    }
}
