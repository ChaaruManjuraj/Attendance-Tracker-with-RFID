package com.example.attendancetracker;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AttendanceList extends ArrayAdapter<Attendance> {

    private Activity context;
    private List<Attendance> attendanceList;

    public AttendanceList(Activity context, List<Attendance> attendanceList) {
        super(context, R.layout.list_layout, attendanceList);
        this.context = context;
        this.attendanceList = attendanceList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

//        TextView textViewName = (TextView) listViewItem.findViewById(R.id.name);
        TextView textViewUSN = (TextView) listViewItem.findViewById(R.id.usn);
//        TextView textViewAttendancePercent = (TextView) listViewItem.findViewById(R.id.attendance_percent);
//        TextView textViewAttendance = (TextView) listViewItem.findViewById(R.id.attendance);

        Attendance attendanceObj = attendanceList.get(position);

//        textViewName.setText("NAME: " + attendanceObj.getName());
        textViewUSN.setText("USN:" + attendanceObj.getUsn());
//        textViewAttendancePercent.setText("% ATTENDANCE: " + attendanceObj.getAttendance_percent());
//        textViewAttendance.setText(attendanceObj.getAttendance().toString());
//        textViewAttendance.setText(
//                attendanceObj.getAttendance() ?
//                        "STATUS: PRESENT" :
//                        "STATUS: ABSENT"
//        );

        return listViewItem;

    }
}
