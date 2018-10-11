package com.smartdroidesign.loginmockup.ui;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdroidesign.loginmockup.R;
import com.smartdroidesign.loginmockup.model.User;
import com.smartdroidesign.loginmockup.presenter.UserInfoActivity;

public class MainActivity extends AppCompatActivity {

    private TextView headerTxt;
    private TextView textInputUsername;
    private TextView textInputPassword;
    private Button signinBtn;

    private User matteo;
    private User giacomo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headerTxt = findViewById(R.id.headerTextView);
        textInputUsername = findViewById(R.id.userNameTxt);
        textInputPassword = findViewById(R.id.userPasswordTxt);
        signinBtn = findViewById(R.id.signInBtn);


        matteo = new User("Matteo", "Stara", "male", 34);
        giacomo = new User("Giacomo", "Rebonati", "male", 30);


        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);

                if (TextUtils.isEmpty(textInputPassword.getText()) || TextUtils.isEmpty(textInputUsername.getText())) {
                    Toast.makeText(MainActivity.this, "You need to enter a valid user name and password", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra("matteo", matteo);
                    intent.putExtra("giacomo", giacomo);
                    startActivity(intent);
                }
            }
        });

    }
}
