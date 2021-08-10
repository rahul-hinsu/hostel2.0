package com.rkitsoftware.hostel.SigninActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rkitsoftware.hostel.Dashboard.StudentDashboard;
import com.rkitsoftware.hostel.ForgetPasswordActivity.ForgetPassword;
import com.rkitsoftware.hostel.R;
import com.rkitsoftware.hostel.SignupActivity.SignUp;

public class SignIn extends AppCompatActivity implements View.OnClickListener{

    TextView txt_signup,txt_loginfaculty,txt_frgtPass;
    Button btn_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initView();
    }

    private void initView() {
        txt_signup = findViewById(R.id.txt_signup);
        txt_loginfaculty = findViewById(R.id.txt_loginfaculty);
        txt_frgtPass = findViewById(R.id.txt_frgtPass);
        btn_signin = findViewById(R.id.btn_signin);


        txt_signup.setOnClickListener(this);
        txt_loginfaculty.setOnClickListener(this);
        txt_frgtPass.setOnClickListener(this);
        btn_signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.txt_signup:
                Intent i = new Intent(SignIn.this, SignUp.class);
                startActivity(i);
                break;

            case R.id.txt_loginfaculty:
                Intent loginfac = new Intent(SignIn.this, FacultySignIn.class);
                startActivity(loginfac);
                break;

            case R.id.txt_frgtPass:
                Intent frgtpass = new Intent(SignIn.this, ForgetPassword.class);
                startActivity(frgtpass);
                break;

            case R.id.btn_signin:
                Intent signin = new Intent(SignIn.this, StudentDashboard.class);
                startActivity(signin);
                break;

            default:
                break;
        }
    }
}