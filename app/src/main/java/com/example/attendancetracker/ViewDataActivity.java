package com.example.attendancetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ViewDataActivity extends AppCompatActivity {

    ListView listViewAttendance;
    List<Attendance> attendanceList;
    DatabaseReference DbAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        DbAttendance = FirebaseDatabase.getInstance().getReference();
        attendanceList = new ArrayList<>();
        listViewAttendance = (ListView) findViewById(R.id.list_view_attendance);
    }

    @Override
    protected void onStart() {
        super.onStart();
        DbAttendance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot attendanceSnapshot: snapshot.getChildren()) {
//                    Log.e("TAG", attendanceSnapshot.toString());
                    String USN = attendanceSnapshot.getValue().toString();
                    Attendance attendanceObj = new Attendance(USN);
                    attendanceList.add(attendanceObj);
                }

                AttendanceList adapter = new AttendanceList(ViewDataActivity.this, attendanceList);
                listViewAttendance.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {
//                HANDLE CLEAN-UP
            }
        });

    }
}