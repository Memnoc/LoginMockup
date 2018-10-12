package com.smartdroidesign.loginmockup.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.smartdroidesign.loginmockup.R;
import com.smartdroidesign.loginmockup.model.User;
import com.smartdroidesign.loginmockup.presenter.UserInfoActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText pswEditText;
    private EditText surnameEditText;
    private EditText genderEditText;
    private EditText ageEditText;
    TextView headerTextView;

    private Button signBtnMain;

    // Variables
    private String name;
    private String surname;
    private String gender;
    private String age;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Views Registering
        headerTextView = findViewById(R.id.header_txt_main);
        nameEditText = findViewById(R.id.name_txt_main);
        surnameEditText = findViewById(R.id.surname_txt_main);
        pswEditText = findViewById(R.id.psw_txt_main);
        genderEditText = findViewById(R.id.gender_txt_main);
        ageEditText = findViewById(R.id.age_txt_main);
        signBtnMain = findViewById(R.id.sign_btn_main);

        // TextWatcher
        nameEditText.addTextChangedListener(loginTextWatcher);
        surnameEditText.addTextChangedListener(loginTextWatcher);
        pswEditText.addTextChangedListener(loginTextWatcher);
        genderEditText.addTextChangedListener(loginTextWatcher);
        ageEditText.addTextChangedListener(loginTextWatcher);


        // OnClick Button
        signBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
                User user = new User(name, surname, gender, age, password);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        // Only important method
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            name = nameEditText.getText().toString().trim();
            surname = surnameEditText.getText().toString().trim();
            gender = genderEditText.getText().toString().trim();
            age = ageEditText.getText().toString().trim();
            password = pswEditText.getText().toString().trim();

            signBtnMain.setEnabled(!name.isEmpty() && !surname.isEmpty() && !gender.isEmpty() && !age.isEmpty() && !password.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
