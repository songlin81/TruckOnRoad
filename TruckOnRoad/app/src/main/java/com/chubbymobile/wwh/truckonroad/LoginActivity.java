package com.chubbymobile.wwh.truckonroad;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button logon;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        username = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        findViewById(R.id.name).getLayoutParams().width = getScreenWidth()/4*3;
        findViewById(R.id.password).getLayoutParams().width = getScreenWidth()/4*3;
        logon = (Button)findViewById(R.id.button);
        logon.getLayoutParams().width = getScreenWidth()/3;

        logon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (performCredentialCheck(username.getText().toString(), password.getText().toString())) {
                    startActivity(new Intent(LoginActivity.this, OnlineBookingActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // this is so far no-brainer function call, replace it with base-page and valid credential check
    // one day...
    private boolean performCredentialCheck(String user, String password){
        return user.equals("admin") && password.equals("admin");
    }

    private int getScreenWidth() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }
}
