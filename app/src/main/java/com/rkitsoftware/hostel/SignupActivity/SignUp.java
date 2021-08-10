package com.rkitsoftware.hostel.SignupActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rkitsoftware.hostel.R;

public class SignUp extends AppCompatActivity {

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this,SignUpSuccess.class );
                startActivity(i);
            }
        });
    }

    private void initView() {
        submit = findViewById(R.id.btn_signupsubmit);
    }

}