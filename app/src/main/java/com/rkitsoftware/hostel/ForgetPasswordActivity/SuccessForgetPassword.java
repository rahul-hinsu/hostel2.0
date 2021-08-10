package com.rkitsoftware.hostel.ForgetPasswordActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rkitsoftware.hostel.R;

public class SuccessForgetPassword extends AppCompatActivity {

    Button btn_backsucesfrgtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_forget_password);

        initView();

        btn_backsucesfrgtpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        btn_backsucesfrgtpass = findViewById(R.id.btn_backsucesfrgtpass);
    }
}