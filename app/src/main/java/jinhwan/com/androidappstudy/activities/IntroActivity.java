package jinhwan.com.androidappstudy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import jinhwan.com.androidappstudy.R;
import jinhwan.com.androidappstudy.activities.base.BaseActivity;
import jinhwan.com.androidappstudy.activities.utils.Connection;
import jinhwan.com.androidappstudy.activities.utils.Preferences;


public class IntroActivity extends BaseActivity {

    private Preferences preferences;

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

    public Preferences getPreferences() {
        preferences = Preferences.getInstance();
        preferences.setInit(this);
        return preferences;
    }

    private Handler handler = new IntroHandler(this);
}


class IntroHandler extends Handler {
    private final WeakReference<IntroActivity> ref;

    IntroHandler(IntroActivity act) {
        ref = new WeakReference<>(act);
    }

    public void handleMessage(Message msg) {
        IntroActivity act = ref.get();
        Intent intent;
        if (msg.what == 0) {
            boolean isLogin = act.getPreferences().getValue("login", false, Connection.LOGIN);
            if(isLogin) {
                intent = new Intent(act.getApplicationContext(), MainActivity.class);
            }
            else {
                intent = new Intent(act.getApplicationContext(), LoginActivity.class);
            }
            act.startActivity(intent);
            act.overridePendingTransition(R.anim.page_from_right, R.anim.page_to_left);
            act.finish();
        }
    }
}