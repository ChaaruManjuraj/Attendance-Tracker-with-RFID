package com.example.attendancetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertDataActivity extends AppCompatActivity {

    private EditText edit_name;
    private EditText edit_usn;
    private EditText edit_attendance_percent;
    private RadioGroup radio_attendance;
    private Button btnSubmit;
    private Boolean attendance = true;

    DatabaseReference DbAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        DbAttendance = FirebaseDatabase.getInstance().getReference("attendance");

        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_usn = (EditText) findViewById(R.id.edit_usn);
        edit_attendance_percent = (EditText) findViewById(R.id.edit_attendance_percent);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        radio_attendance = (RadioGroup) findViewById(R.id.radio_group);

        radio_attendance.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.radio_present:
                        attendance = true;
                        break;
                    case R.id.radio_absent:
                        attendance = false;
                        break;
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

    }

    private void insertData() {
        String name = edit_name.getText().toString().trim();
        String usn = edit_usn.getText().toString().trim();
        String attendance_percent = edit_attendance_percent.getText().toString().trim();

//        Attendance attendanceObj = new Attendance(name, usn, attendance_percent, attendance);

        if(!TextUtils.isEmpty(name) || !TextUtils.isEmpty(usn) || !TextUtils.isEmpty(attendance_percent)) {

//            DbAttendance.child(usn).setValue(attendanceObj);
            Toast.makeText(this, "Data Inserted!", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "Please fill-in all fields before submitting", Toast.LENGTH_SHORT).show();
        }
    }
}