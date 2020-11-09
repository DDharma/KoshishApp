package com.example.koshishapp

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_show_attendance.*
import java.util.*

class ShowAttendance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_attendance)


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

        }

        end_date_text.setOnClickListener { view ->
            //DatePicker(view)
            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(this,"$year-$month-$dayOfMonth",Toast.LENGTH_LONG).show()
                val selectedDate = "$year-${month+1}-$dayOfMonth"
                end_date_text.text = selectedDate

            },
                year,
                month,
                dayOfMonth).show()
        }

        //On click listner by which we can show the attendance
        view_attendance.setOnClickListener {
            val sDate = start_date_text.text
            if (sDate is String){
                Toast.makeText(this,sDate,Toast.LENGTH_LONG).show()
            }
        }


    }
}





