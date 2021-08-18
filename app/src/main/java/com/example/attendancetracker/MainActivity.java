package com.example.attendancetracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUsername,etPassword;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btSubmit = findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("1RN18EC132") &&
                etPassword.getText().toString().equals("RNSIT_2022")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            MainActivity.this
                    );
                    builder.setIcon(R.drawable.ic_baseline_check_circle_24);
                    builder.setTitle("Login Successful");
                    builder.setMessage("Welcome to Attendance Tracker");

                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(v.getContext(), HomeActivity.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else {
                    Toast.makeText(getApplicationContext(),
                            "Invalid USN & Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}