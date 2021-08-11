package com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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

    int numRoom;
    int bedPerRoom;
    int totalSeats;
    int scSeats;
    int stSeats;
    int obcSeats;
    int openSeats;
    ArrayList<SignupModel> arrayList=new ArrayList<>();
    ArrayList<SignupModel> arrayList_sc=new ArrayList<>();
    ArrayList<SignupModel> arrayList_st=new ArrayList<>();
    ArrayList<SignupModel> arrayList_obc=new ArrayList<>();
    ArrayList<SignupModel> arrayList_open=new ArrayList<>();
    ArrayList<SignupModel> arrayList_allocated=new ArrayList<>();
    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_allocation);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference().child("signup");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()){
                    Map<String, Object> data = (Map<String, Object>) snap.getValue();
                    SignupModel student = new SignupModel();
                    student.setCategory(data.get("category").toString());
                    student.setAcpcRank(data.get("acpc_rank").toString());
                    student.setBranch(data.get("branch").toString());
                    student.setCity(data.get("city").toString());
                    student.setDocument(data.get("document").toString());
                    student.setEmail(data.get("email").toString());
                    student.setEnrollNo(Long.parseLong(data.get("enroll_no").toString()));
                    student.setIsApproved(data.get("isApproved").toString());
                    student.setName(data.get("name").toString());
                    student.setMobileNo(data.get("mobile_no").toString());

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
                for(int i=0;i<arrayList.size();i++){
                    if(arrayList.get(i).getCategory().equals("ST")){
                        arrayList_st.add(arrayList.get(i));
                    }
                }
                for(int i=0;i<arrayList.size();i++){
                    if(arrayList.get(i).getCategory().equals("OBC")){
                        arrayList_obc.add(arrayList.get(i));
                    }
                }
                for(int i=0;i<arrayList.size();i++){
                    if(arrayList.get(i).getCategory().equals("OPEN")){
                        arrayList_open.add(arrayList.get(i));
                    }
                }

                for(int i=0;i<arrayList_sc.size();i++){
                    for(int j=0;j<arrayList_sc.size()-i-1;j++){
                        if(Integer.parseInt(arrayList_sc.get(j).getAcpcRank())>(Integer.parseInt(arrayList_sc.get(j+1).getAcpcRank()))){
                            SignupModel tmp = arrayList_sc.get(j);
                            arrayList_sc.set(j, arrayList_sc.get(j+1));
                            arrayList_sc.set(j+1, tmp);
                        }
                    }
                }

                for(int i=0;i<arrayList_st.size();i++){
                    for(int j=0;j<arrayList_st.size()-i-1;j++){
                        if(Integer.parseInt(arrayList_st.get(j).getAcpcRank())>(Integer.parseInt(arrayList_st.get(j+1).getAcpcRank()))){
                            SignupModel tmp = arrayList_st.get(j);
                            arrayList_st.set(j, arrayList_st.get(j+1));
                            arrayList_st.set(j+1, tmp);
                        }
                    }
                }

                for(int i=0;i<arrayList_obc.size();i++){
                    for(int j=0;j<arrayList_obc.size()-i-1;j++){
                        if(Integer.parseInt(arrayList_obc.get(j).getAcpcRank())>(Integer.parseInt(arrayList_obc.get(j+1).getAcpcRank()))){
                            SignupModel tmp = arrayList_obc.get(j);
                            arrayList_obc.set(j, arrayList_obc.get(j+1));
                            arrayList_obc.set(j+1, tmp);
                        }
                    }
                }

                for(int i=0;i<scSeats;i++){
                    arrayList_allocated.add(arrayList_sc.get(i));
                    Log.d("-----", arrayList_sc.get(i).getAcpcRank());
                }
                /*for(int i=0;i<stSeats;i++){
                    arrayList_allocated.add(arrayList_st.get(i));
                }
                for(int i=0;i<obcSeats;i++){
                    arrayList_allocated.add(arrayList_obc.get(i));
                }
                for(int i=0;i<arrayList_allocated.size();i++){
                    Log.d("yoo",arrayList_allocated.get(i).getAcpcRank()+""+arrayList_allocated.get(i).getCategory());
                }*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        }


//    }

    void shortStudent(){

    }
}