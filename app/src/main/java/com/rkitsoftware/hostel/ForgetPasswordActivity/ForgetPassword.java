package com.rkitsoftware.hostel.ForgetPasswordActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.app.AsyncNotedAppOp;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rkitsoftware.hostel.R;

public class ForgetPassword extends AppCompatActivity {

    Button submit;
    EditText et_email;
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        initView();
        et_email = findViewById(R.id.edtxt_email);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = et_email.getText().toString();
                SendMail sm = new SendMail(ForgetPassword.this, email);
                sm.execute();
                Intent i = new Intent(ForgetPassword.this, SuccessForgetPassword.class);
                startActivity(i);
            }
        });

    }

    private void initView() {
        submit = findViewById(R.id.btn_submitfrgtpass);
    }
}

class SendMail extends AsyncTask {


    private Context context;
    private Session session;
    private String email;

    public SendMail(Context context, String email){
        this.context = context;
        this.email = email;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        String EMAIL ="neiljaviya5@gmail.com";
        String PASSWORD ="neiljaviya@612";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });
        try {
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress(EMAIL));
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            mm.setSubject("Forgot Password");
            mm.setText("aa ryo taro password: asjhvddyusyuv");
            Transport.send(mm);
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
    }
