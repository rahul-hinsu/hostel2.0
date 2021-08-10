package com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rkitsoftware.hostel.Model.SignupModel;
import com.rkitsoftware.hostel.R;

import java.util.ArrayList;
import java.util.Map;

public class RoomAllocation extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    SignupModel[] stu2 = new SignupModel[100];

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

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("signup");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i = 0;
                for(DataSnapshot ds: snapshot.getChildren()){
                    SignupModel tmp;
                    tmp = ds.getValue(SignupModel.class);
                    stu2[i] = tmp;
                    i++;
                }
                Log.d("h","----------------"+ stu2[3].getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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