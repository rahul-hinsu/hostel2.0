package com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rkitsoftware.hostel.R;

import java.util.ArrayList;
import java.util.Map;

public class FeesNotification extends AppCompatActivity {

    FirebaseDatabase db;
    EditText msgInput;
    Button send;
    DatabaseReference ref;
    Long count;

    ArrayList<String> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_notification);
        FirebaseApp.initializeApp(FeesNotification.this);
        msgInput = findViewById(R.id.mailmsg);
        send = findViewById(R.id.btn_send);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference().child("candidate");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()){
                    Map<String, Object> data = (Map<String, Object>) snap.getValue();
                    Log.d("abcd", data.get("email").toString());
                    arrayList.add(data.get("email").toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND_MULTIPLE);

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{String.valueOf(arrayList)});

                intent.setType("messsage/rfc822");

                intent.putExtra(Intent.EXTRA_SUBJECT,"Hostel Notification");
                intent.putExtra(Intent.EXTRA_TEXT,msgInput.getText().toString());


                startActivity(Intent.createChooser(intent,  "Choose an email client"));
            }
        });
    }
}