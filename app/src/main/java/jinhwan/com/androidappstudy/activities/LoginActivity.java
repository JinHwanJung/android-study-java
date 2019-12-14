package jinhwan.com.androidappstudy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jinhwan.com.androidappstudy.R;
import jinhwan.com.androidappstudy.activities.base.BaseActivity;
import jinhwan.com.androidappstudy.activities.utils.Connection;
import jinhwan.com.androidappstudy.activities.utils.Preferences;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText login_edit_id, login_edit_pw;
    private Button login_button;
    private Preferences preferences;

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
        preferences = Preferences.getInstance();
        preferences.setInit(this);
    }

    @Override
    public void onClick(View view) {
        String id = login_edit_id.getText().toString().trim();
        String pw = login_edit_id.getText().toString().trim();
        check(id, pw);
    }

    private void check(String id, String pw) {
        boolean isCorrect = id.equals("test123") && pw.equals("test123");
        if (id.equals("")) Toast.makeText(getApplicationContext(), getString(R.string.msg_input_id), Toast.LENGTH_SHORT).show();
        else if (id.length() < 6) Toast.makeText(getApplicationContext(), getString(R.string.msg_input_length_id), Toast.LENGTH_SHORT).show();
        else if (pw.equals("")) Toast.makeText(getApplicationContext(), getString(R.string.msg_input_pw), Toast.LENGTH_SHORT).show();
        else if (pw.length() < 5) Toast.makeText(getApplicationContext(), getString(R.string.msg_input_length_pw), Toast.LENGTH_SHORT).show();
        else if (!isCorrect) Toast.makeText(getApplicationContext(), getString(R.string.msg_login_fail), Toast.LENGTH_SHORT).show();
        else {
            // TODO: id and pw 는 현재 데모 API 통신코드 추가 예정
            preferences.put("login", true, Connection.LOGIN);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }
}
