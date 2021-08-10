package com.rkitsoftware.hostel.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem.AddRemoveRoom;
import com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem.EditRoomField.EditRooms;
import com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem.FeesNotification;
import com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem.RoomAllocation;
import com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem.SearchStudentField.SearchStudent;
import com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem.ViewRequestField.ViewRequest;
import com.rkitsoftware.hostel.ForgetPasswordActivity.ForgetPassword;
import com.rkitsoftware.hostel.R;
import com.rkitsoftware.hostel.SigninActivity.FacultySignIn;
import com.rkitsoftware.hostel.SigninActivity.SignIn;
import com.rkitsoftware.hostel.SignupActivity.SignUp;

public class FacultyDashboard extends AppCompatActivity implements View.OnClickListener {

    Button btn_viewrequest, btn_roomallocate, btn_searchStudent, btn_feesnotification, btn_editrooms, btn_addroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_dashboard);
        initView();
    }

    private void initView() {
        btn_viewrequest = findViewById(R.id.btn_viewrequest);
        btn_roomallocate = findViewById(R.id.btn_roomallocate);
        btn_searchStudent = findViewById(R.id.btn_searchStudent);
        btn_feesnotification = findViewById(R.id.btn_feesnotification);
        btn_editrooms = findViewById(R.id.btn_editrooms);
        btn_addroom = findViewById(R.id.btn_addroom);

        btn_viewrequest.setOnClickListener(this);
        btn_roomallocate.setOnClickListener(this);
        btn_searchStudent.setOnClickListener(this);
        btn_feesnotification.setOnClickListener(this);
        btn_editrooms.setOnClickListener(this);
        btn_addroom.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_viewrequest:
                Intent viewrequest = new Intent(FacultyDashboard.this, ViewRequest.class);
                startActivity(viewrequest);
                break;

            case R.id.btn_roomallocate:
                Intent roomallocate = new Intent(FacultyDashboard.this, RoomAllocation.class);
                startActivity(roomallocate);
                break;

            case R.id.btn_searchStudent:
                Intent searchStudent = new Intent(FacultyDashboard.this, SearchStudent.class);
                startActivity(searchStudent);
                break;

            case R.id.btn_feesnotification:
                Intent feesnotification = new Intent(FacultyDashboard.this, FeesNotification.class);
                startActivity(feesnotification);
                break;

            case R.id.btn_editrooms:
                Intent editrooms = new Intent(FacultyDashboard.this, EditRooms.class);
                startActivity(editrooms);
                break;

            case R.id.btn_addroom:
                Intent addroom = new Intent(FacultyDashboard.this, AddRemoveRoom.class);
                startActivity(addroom);
                break;

            default:
                break;
        }
    }
}

