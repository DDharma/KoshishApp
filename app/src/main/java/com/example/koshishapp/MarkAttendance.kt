package com.example.koshishapp

import android.app.DatePickerDialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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

        val progressBar2 = ProgressDialog(this)
        progressBar2.setMessage("Loading the Content ... ")
        progressBar2.setCancelable(false)
        progressBar2.show()
        Handler().postDelayed({progressBar2.dismiss()},5000)

        //Calling Get Member Api To get the Member Name from DataBase
        ApiCalRequest().memberNames()!!.observe(this, androidx.lifecycle.Observer{

            val myAdapter = AdapterMarkAttendance(it.member_data_json,this)
            markAttendanceRecyclerview.layoutManager = LinearLayoutManager(this)
            markAttendanceRecyclerview.adapter = myAdapter
        })

    }
}