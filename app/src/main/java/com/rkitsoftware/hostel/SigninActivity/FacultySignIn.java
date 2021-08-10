package com.rkitsoftware.hostel.SigninActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rkitsoftware.hostel.Dashboard.FacultyDashboard;
import com.rkitsoftware.hostel.R;

public class FacultySignIn extends AppCompatActivity implements View.OnClickListener {

    Button btn_signinfaculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_sign_in);

        initView();
    }

    private void initView() {
        btn_signinfaculty = findViewById(R.id.btn_signinfaculty);

        btn_signinfaculty.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_signinfaculty:
                Intent i = new Intent(FacultySignIn.this, FacultyDashboard.class);
                startActivity(i);
                break;

            default:
                break;
        }
    }
}