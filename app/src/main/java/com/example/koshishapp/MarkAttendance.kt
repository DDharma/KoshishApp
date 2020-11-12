package com.example.koshishapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_mark_attendance.*
import kotlinx.android.synthetic.main.activity_show_attendance.*
import java.util.*
import kotlin.collections.ArrayList

class MarkAttendance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mark_attendance)

        val arrayList = ArrayList<ModelMarkAttendance>()

        arrayList.add(ModelMarkAttendance("Dharmvir Dharmacharya"))
        arrayList.add(ModelMarkAttendance("Abhishek Soni"))
        arrayList.add(ModelMarkAttendance("Nandani"))
        arrayList.add(ModelMarkAttendance("Rivya Bist"))
        arrayList.add(ModelMarkAttendance("Manik Rastogi"))
        arrayList.add(ModelMarkAttendance("Anjali Bawa"))
        arrayList.add(ModelMarkAttendance("Netrika Chhetri"))

        val myAdapter = AdapterMarkAttendance(arrayList,this)

        markAttendanceRecyclerview.layoutManager = LinearLayoutManager(this)
        markAttendanceRecyclerview.adapter = myAdapter

    }
}