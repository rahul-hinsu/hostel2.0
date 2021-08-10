package com.rkitsoftware.hostel.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rkitsoftware.hostel.R;

public class StudentDashboard extends AppCompatActivity {

    Button btn_updateprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        initView();

        btn_updateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentDashboard.this,StudentProfile.class);
                startActivity(i);
            }
        });
    }

    private void initView() {
        btn_updateprofile = findViewById(R.id.btn_updateprofile);
    }
}