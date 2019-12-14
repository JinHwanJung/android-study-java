package jinhwan.com.androidappstudy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import jinhwan.com.androidappstudy.R;
import jinhwan.com.androidappstudy.activities.base.BaseActivity;


class IntroHandler extends Handler {
    private final WeakReference<BaseActivity> ref;

    IntroHandler(BaseActivity act) {
        ref = new WeakReference<>(act);
    }

    public void handleMessage(Message msg) {
        BaseActivity act = ref.get();
        switch (msg.what) {
            case 0:
                act.startActivity(new Intent(act.getApplicationContext(), MainActivity.class));
                act.overridePendingTransition(R.anim.page_from_right, R.anim.page_to_left);
                act.finish();
                break;
        }
    }
}


public class IntroActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_intro;
    }

    @Override
    protected int getStatusBar() {
        return 3;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    private Handler handler = new IntroHandler(this);
}
