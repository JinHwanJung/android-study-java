package jinhwan.com.androidappstudy.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jinhwan.com.androidappstudy.R;
import jinhwan.com.androidappstudy.activities.base.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText login_edit_id, login_edit_pw;
    private Button login_button;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getStatusBar() {
        return 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        login_edit_id = findViewById(R.id.login_edit_id);
        login_edit_pw = findViewById(R.id.login_edit_pw);
        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String id = login_edit_id.getText().toString().trim();
    }
}
