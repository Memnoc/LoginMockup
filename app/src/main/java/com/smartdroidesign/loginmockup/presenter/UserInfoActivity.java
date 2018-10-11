package com.smartdroidesign.loginmockup.presenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.smartdroidesign.loginmockup.R;
import com.smartdroidesign.loginmockup.model.User;

public class UserInfoActivity extends AppCompatActivity {

    private TextView firstNameResult;
    private TextView lastNameResult;
    private TextView genderResult;
    private TextView ageResult;
    private TextView welcomeMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        firstNameResult = findViewById(R.id.userNameResult);
        lastNameResult = findViewById(R.id.userLastNameResult);
        genderResult = findViewById(R.id.userGenderResult);
        ageResult = findViewById(R.id.userAgeResult);
        welcomeMessage = findViewById(R.id.welcomeMessageResult);

        // User objects
        User matteo = getIntent().getParcelableExtra("matteo");
        User giacomo = getIntent().getParcelableExtra("giacomo");



            firstNameResult.setText(matteo.getFirstName());
            lastNameResult.setText(matteo.getLastName());
            genderResult.setText(matteo.getGender());
            ageResult.setText(String.valueOf(matteo.getAge()));
            welcomeMessage.setText(String.format("Welcome, %s", matteo.getFirstName()));



            firstNameResult.setText(giacomo.getFirstName());
            lastNameResult.setText(giacomo.getLastName());
            genderResult.setText(giacomo.getGender());
            ageResult.setText(String.valueOf(giacomo.getAge()));
            welcomeMessage.setText(String.format("Welcome, %s", giacomo.getFirstName()));


//            firstNameResult.setError(null);
//            lastNameResult.setError(null);
//            genderResult.setError(null);
//            ageResult.setError(null);
//            welcomeMessage.setText(" User does not exist");
////            Toast.makeText(UserInfoActivity.this, "The user does not exist", Toast.LENGTH_LONG).show();
        }

}
