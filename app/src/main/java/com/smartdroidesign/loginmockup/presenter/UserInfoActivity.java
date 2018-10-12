package com.smartdroidesign.loginmockup.presenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdroidesign.loginmockup.R;
import com.smartdroidesign.loginmockup.model.User;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView firstNameResult = findViewById(R.id.userNameResult);
        TextView lastNameResult = findViewById(R.id.userLastNameResult);
        TextView genderResult = findViewById(R.id.userGenderResult);
        TextView ageResult = findViewById(R.id.userAgeResult);
        TextView welcomeMessage = findViewById(R.id.welcomeMessageResult);

        // User object
        User user = getIntent().getParcelableExtra("user");

        // Build user
        firstNameResult.setText(user.getFirstName());
        lastNameResult.setText(user.getLastName());
        genderResult.setText(user.getGender());
        ageResult.setText(String.valueOf(user.getAge()));
        welcomeMessage.setText(String.format("Welcome, %s", user.getFirstName()));

    }

}
