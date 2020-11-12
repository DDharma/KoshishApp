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

        //Calling Get Member Api To get the Member Name from DataBase
        ApiCalRequest().memberNames()!!.observe(this, androidx.lifecycle.Observer{

            val myAdapter = AdapterMarkAttendance(it.member_data_json,this)
            markAttendanceRecyclerview.layoutManager = LinearLayoutManager(this)
            markAttendanceRecyclerview.adapter = myAdapter
        })

        /*
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
        markAttendanceRecyclerview.adapter = myAdapter*/

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

    }
}