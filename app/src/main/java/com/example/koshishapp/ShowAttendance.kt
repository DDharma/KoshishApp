package com.example.koshishapp

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_mark_attendance.*
import kotlinx.android.synthetic.main.activity_show_attendance.*
import java.util.*

class ShowAttendance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_attendance)

        //Calling Get Member Api To get the Member Name from DataBase
        ApiCalRequest().memberNames()!!.observe(this, androidx.lifecycle.Observer{

            val myAdapter = AdapterShowAttendance(it.member_data_json,this)
            showAttendanceRecyclerview.layoutManager = LinearLayoutManager(this)
            showAttendanceRecyclerview.adapter = myAdapter
        })
/*
        //Function Calling which show the Date Picker Dialog
        start_date_text.setOnClickListener { view ->
            //DatePicker(view)
            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(this,"$year-$month-$dayOfMonth",Toast.LENGTH_LONG).show()
                val selectedDate = "$year-${month+1}-$dayOfMonth"
                start_date_text.text = selectedDate


            },
                year,
                month,
                dayOfMonth).show()

        }*/
        /*
        val arrayList = ArrayList<ModelShowAttendance>()

        arrayList.add(ModelShowAttendance("Dharmvir Dharmacharya"))
        arrayList.add(ModelShowAttendance("Abhishek Soni"))
        arrayList.add(ModelShowAttendance("Nandani"))
        arrayList.add(ModelShowAttendance("Rivya Bist"))
        arrayList.add(ModelShowAttendance("Manik Rastogi"))
        arrayList.add(ModelShowAttendance("Anjali Bawa"))
        arrayList.add(ModelShowAttendance("Netrika Chhetri"))



        val myAdapter = AdapterShowAttendance(arrayList,this)

        showAttendanceRecyclerview.layoutManager = LinearLayoutManager(this)
        showAttendanceRecyclerview.adapter = myAdapter*/
    }
}





