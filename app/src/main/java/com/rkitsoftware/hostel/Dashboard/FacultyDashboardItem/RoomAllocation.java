package com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rkitsoftware.hostel.R;

public class RoomAllocation extends AppCompatActivity {

    int numRoom;
    int bedPerRoom;
    int totalSeats;
    int scSeats;
    int stSeats;
    int obcSeats;
    int openSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_allocation);

        totalSeats = numRoom * bedPerRoom;
        scSeats = (int)(totalSeats * 0.15);
        stSeats = (int)(totalSeats * 0.075);
        obcSeats = (int)(totalSeats * 0.27);
        openSeats = totalSeats - scSeats - stSeats - obcSeats;
        shortStudent();
    }

    void shortStudent(){

    }
}