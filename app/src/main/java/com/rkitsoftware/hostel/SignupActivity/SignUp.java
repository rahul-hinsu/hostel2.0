package com.rkitsoftware.hostel.SignupActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rkitsoftware.hostel.Dashboard.FacultyDashboardItem.EditRoomField.EditRooms;
import com.rkitsoftware.hostel.Dashboard.StudentDashboard;
import com.rkitsoftware.hostel.ForgetPasswordActivity.ForgetPassword;
import com.rkitsoftware.hostel.Model.SignupModel;
import com.rkitsoftware.hostel.R;
import com.rkitsoftware.hostel.SigninActivity.FacultySignIn;
import com.rkitsoftware.hostel.SigninActivity.SignIn;

import java.util.Random;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    Button submit;
    EditText edttxt_Name,edttxt_Enroll,edttxt_branch,edttxt_category,edttxt_mobileno,edttxt_email,edttxt_acpcrank;
    TextView txt_signin,txt_loginfacultysignup;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Long lng_enroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();

    }

    private void initView() {
        edttxt_Name = findViewById(R.id.edttxt_Name);
        edttxt_Enroll = findViewById(R.id.edttxt_Enroll);
        edttxt_branch = findViewById(R.id.edttxt_branch);
        edttxt_category = findViewById(R.id.edttxt_category);
        edttxt_mobileno = findViewById(R.id.edttxt_mobileno);
        edttxt_email = findViewById(R.id.edttxt_email);
        edttxt_acpcrank = findViewById(R.id.edttxt_acpcrank);
        txt_signin = findViewById(R.id.txt_signin);
        txt_loginfacultysignup = findViewById(R.id.txt_loginfacultysignin);
        submit = findViewById(R.id.btn_signupsubmit);

        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_signupsubmit:

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("signup");

                String strName = edttxt_Name.getText().toString();
                String strEnroll = edttxt_Enroll.getText().toString();
                if(!strEnroll.isEmpty()) {
                    lng_enroll = Long.parseLong(strEnroll);
                }
                String strBranch = edttxt_branch.getText().toString();
                String strCategory = edttxt_category.getText().toString();
                String strMobileno = edttxt_mobileno.getText().toString();
                String strEmail = edttxt_email.getText().toString();
                String strAcpcRank = edttxt_acpcrank.getText().toString();

                if(edttxt_mobileno.length()<10){
                    showPopup("Invalid mobile number");
                }

                SignupModel signupModel = new SignupModel(strAcpcRank,strBranch,strCategory,"Rajkot","NA",strEmail,lng_enroll,"Yes",strMobileno,strName);

                reference.child(strEnroll).setValue(signupModel);

//                Email(strEmail);


                Intent i = new Intent(SignUp.this, SignUpSuccess.class);
                startActivity(i);
                break;

            case R.id.txt_signin:
                Intent signin = new Intent(SignUp.this, SignIn.class);
                startActivity(signin);
                break;

            case R.id.txt_loginfacultysignin:
                Intent facultySignin = new Intent(SignUp.this, FacultySignIn.class);
                startActivity(facultySignin);
                break;
            default:
                break;
        }
    }


    public void showPopup(String msg){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SignUp.this);
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
//    public static String random() {
//        Random generator = new Random();
//        StringBuilder randomStringBuilder = new StringBuilder();
//        char tempChar;
//        for (int i = 0; i < 8; i++){
//            tempChar = (char) (generator.nextInt(96) + 32);
//            randomStringBuilder.append(tempChar);
//        }
//        return randomStringBuilder.toString();
//    }

//    public void Email(String emailAddr){
//        Intent intent=new Intent(Intent.ACTION_SEND);
//
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{String.valueOf(emailAddr)});
//
//        intent.setType("messsage/rfc822");
//
//        String msg = "Use this credentials for login\nEmail: "+emailAddr+"\nPassword: "+random();
//        intent.putExtra(Intent.EXTRA_SUBJECT,"Password");
//        intent.putExtra(Intent.EXTRA_TEXT,msg);
//
//
//        startActivity(Intent.createChooser(intent,  "Choose an email client"));
//    }
}