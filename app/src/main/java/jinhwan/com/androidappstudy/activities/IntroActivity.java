package jinhwan.com.androidappstudy.activities;

import jinhwan.com.androidappstudy.R;
import jinhwan.com.androidappstudy.activities.base.BaseActivity;

public class IntroActivity extends BaseActivity {



    @Override
    protected int getLayoutResId() {
        return R.layout.activity_intro;
    }

    @Override
    protected int getStatusBar() {
        return 3;
    }

}
