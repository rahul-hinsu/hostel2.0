package com.rkitsoftware.hostel.SigninActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rkitsoftware.hostel.Dashboard.StudentDashboard;
import com.rkitsoftware.hostel.ForgetPasswordActivity.ForgetPassword;
import com.rkitsoftware.hostel.R;
import com.rkitsoftware.hostel.SignupActivity.SignUp;

import java.util.ArrayList;
import java.util.Map;

public class SignIn extends AppCompatActivity implements View.OnClickListener{

    TextView txt_signup,txt_loginfaculty,txt_frgtPass;
    Button btn_signin;
    EditText edtxt_email,edtxt_pass;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ArrayList listemail, listpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initView();


        listemail = new ArrayList<>();
        listpassword = new ArrayList<>();
    }

    private void initView() {
        txt_signup = findViewById(R.id.txt_signup);
        txt_loginfaculty = findViewById(R.id.txt_loginfaculty);
        txt_frgtPass = findViewById(R.id.txt_frgtPass);
        btn_signin = findViewById(R.id.btn_signin);
        edtxt_email = findViewById(R.id.edtxt_email);
        edtxt_pass = findViewById(R.id.edtxt_pass);

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

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("candidate");

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot snapshot1: snapshot.getChildren()){
                            Map<String,Object> data = (Map<String, Object>) snapshot1.getValue();

                            listemail.add(data.get("email").toString());
                            listpassword.add(data.get("password").toString());

                        }
                        Log.d("h",""+ listemail.get(0));
                        Log.d("p",""+ listpassword.get(0));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


                String stremail = edtxt_email.getText().toString();
                String strpass = edtxt_pass.getText().toString();

                if(stremail.isEmpty()){
                    showPopup("Please enter email address");
                    return;
                }

                if(strpass.isEmpty()){
                    showPopup("Please enter password");
                    return;
                }


                if(listemail.contains(stremail)){
                    int firstIndex = listemail.indexOf(stremail);
                    if (listpassword.get(firstIndex).equals(strpass)) {
                        Intent signin = new Intent(SignIn.this, StudentDashboard.class);
                        startActivity(signin);
                    } else {
                        showPopup("Invalid Password");
                    }
                }
                else{
                    showPopup("Please enter valid email address");
                }


                break;

            default:
                break;
        }
    }

    public void showPopup(String msg){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SignIn.this);
        if (msg != null)
            alertDialog.setTitle(msg);
        if (msg != null)
            alertDialog.setMessage(msg);
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }
}