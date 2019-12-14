package jinhwan.com.androidappstudy.activities;

import android.os.Bundle;
import jinhwan.com.androidappstudy.R;
import jinhwan.com.androidappstudy.activities.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getStatusBar() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
