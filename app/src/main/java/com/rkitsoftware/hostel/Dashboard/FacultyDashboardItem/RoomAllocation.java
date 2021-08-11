package com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.CollapsibleActionView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rkitsoftware.hostel.Model.SignupModel;
import com.rkitsoftware.hostel.R;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class RoomAllocation extends AppCompatActivity {

    int numRoom = 2;
    int bedPerRoom = 1;
    int totalSeats;
    int scSeats;
    int stSeats;
    int obcSeats;
    int openSeats;
    ArrayList<SignupModel> arrayList;
    ArrayList<SignupModel> arrayList_sc;
    ArrayList<SignupModel> arrayList_st;
    ArrayList<SignupModel> arrayList_obc;
    ArrayList<SignupModel> arrayList_open;
    ArrayList<SignupModel> arrayList_allocated;
    FirebaseDatabase db;
    DatabaseReference ref;
    SignupModel student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_allocation);

        arrayList=new ArrayList<>();
        arrayList_sc=new ArrayList<>();
        arrayList_st=new ArrayList<>();
        arrayList_obc=new ArrayList<>();
        arrayList_open=new ArrayList<>();
        arrayList_allocated=new ArrayList<>();
        db = FirebaseDatabase.getInstance();
        ref = db.getReference().child("signup");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()){
                    Map<String, Object> data = (Map<String, Object>) snap.getValue();
                    String category = data.get("category").toString();
                    String acpcRank = data.get("acpcRank").toString();
                    String branch = data.get("branch").toString();
                    String city = data.get("city").toString();
                    String doc = data.get("document").toString();
                    String mail = data.get("email").toString();
                    Long enroll = (Long) data.get("enrollNo");
                    String aprroved = data.get("isApproved").toString();
                    String name = data.get("name").toString();
                    String mobile = data.get("mobileNo").toString();
                    SignupModel student = new SignupModel(acpcRank, branch, category, city, doc, mail, enroll, aprroved, mobile, name);

                    arrayList.add(student);
                }
                totalSeats = numRoom * bedPerRoom;
                scSeats = (int)(totalSeats * 0.15);
                stSeats = (int)(totalSeats * 0.075);
                obcSeats = (int)(totalSeats * 0.27);
                openSeats = totalSeats - scSeats - stSeats - obcSeats;

                for(int i=0;i<arrayList.size();i++){
                    if(arrayList.get(i).getCategory().equals("SC")){
                        arrayList_sc.add(arrayList.get(i));
                    }
                }
                Log.d("-----", arrayList_sc.get(0).getName());
                for(int i=0;i<arrayList.size();i++){
                    if(arrayList.get(i).getCategory().equals("ST")){
                        arrayList_st.add(arrayList.get(i));
                    }
                }
                Log.d("-----", arrayList_st.get(0).getName());
                for(int i=0;i<arrayList.size();i++){
                    if(arrayList.get(i).getCategory().equals("OBC")){
                        arrayList_obc.add(arrayList.get(i));
                    }
                }
                Log.d("-----", arrayList_obc.get(0).getName());
                for(int i=0;i<arrayList.size();i++){
                    if(arrayList.get(i).getCategory().equals("OPEN")){
                        arrayList_open.add(arrayList.get(i));
                    }
                }

                sort(arrayList_sc);
                sort(arrayList_st);
                sort(arrayList_obc);
                sort(arrayList_open);

                Log.d("-----", arrayList_open.get(0).getName());
                Log.d("-----", arrayList_sc.get(0).getName());

                for(int i=0; i< scSeats; i++){
                    arrayList_allocated.add(arrayList_sc.get(i));
                    arrayList_sc.remove(arrayList_sc.get(i));
                }

                for(int i=0; i< stSeats; i++){
                    arrayList_allocated.add(arrayList_st.get(i));
                    arrayList_st.remove(arrayList_st.get(i));
                }

                for(int i=0; i< obcSeats; i++){
                    arrayList_allocated.add(arrayList_obc.get(i));
                    arrayList_obc.remove(arrayList_obc.get(i));
                }

                arrayList_open.addAll(arrayList_sc);
                arrayList_open.addAll(arrayList_st);
                arrayList_open.addAll(arrayList_obc);

                sort(arrayList_open);

                for(int i=0; i< totalSeats-arrayList_allocated.size()+1; i++) {
                    arrayList_allocated.add(arrayList_open.get(i));
                    arrayList_open.remove(arrayList_open.get(i));
                }
                Log.d("---", ""+arrayList_allocated.get(0).getName());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        }
    public static void sort(ArrayList<SignupModel> list)
    {

        list.sort((o1, o2)
                -> o1.getAcpcRank().compareTo(
                o2.getAcpcRank()));
    }


//    }
}
