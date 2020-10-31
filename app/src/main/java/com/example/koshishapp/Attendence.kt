package com.example.koshishapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Attendence : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendence)

        val addMember = findViewById<ImageView>(R.id.add_member);
        val markAtten = findViewById<ImageView>(R.id.mark_attendance);
        val setTime = findViewById<ImageView>(R.id.set_timetable);
        val showAtten = findViewById<ImageView>(R.id.show_attendance);

        //moving to respactive pages
        //for addMember
        addMember.setOnClickListener{
            val intent: Intent = Intent(this@Attendence,Addmember::class.java);
            startActivity(intent);
        }
        //for mark attendance
        markAtten.setOnClickListener{

        }
        //for set time table
        setTime.setOnClickListener {

        }
        //for show attendance
        showAtten.setOnClickListener {

        }

    }
}