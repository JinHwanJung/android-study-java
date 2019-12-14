package jinhwan.com.androidappstudy.activities.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import jinhwan.com.androidappstudy.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract int getLayoutResId();
    protected abstract int getStatusBar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        if (Build.VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            switch (getStatusBar()) {
                case 1:
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    break;
                case 2:
                    window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.half_transparent));
                    window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    break;
                case 3:
                    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    break;
                default:
                    break;
            }
        }
    }
}
