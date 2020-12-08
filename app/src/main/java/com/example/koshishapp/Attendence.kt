package com.example.koshishapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_attendence.*

class Attendence : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendence)

        val addMember = findViewById<ImageView>(R.id.add_member);
        val markAtten = findViewById<ImageView>(R.id.mark_attendance);
        val setTime = findViewById<ImageView>(R.id.set_timetable);
        val showAtten = findViewById<ImageView>(R.id.show_attendance);
        var intent = intent;
        var admin = intent.getStringExtra("admin")

        //moving to respactive pages
        //for addMember
        if (admin == "YES"){
            Toast.makeText(this, "Welcome to Admin login", Toast.LENGTH_SHORT).show();
            addMember.setOnClickListener{
                val intent: Intent = Intent(this@Attendence,Addmember::class.java);
                startActivity(intent);
            }
            //for mark attendance
            markAtten.setOnClickListener{
                val intent: Intent = Intent(this@Attendence,MarkAttendance::class.java);
                startActivity(intent);
            }
            //for set time table
            setTime.setOnClickListener {
                val intent: Intent = Intent(this@Attendence,SetTimeTable::class.java);
                startActivity(intent);

            }
            //for show attendance
            showAtten.setOnClickListener {
                val intent: Intent = Intent(this@Attendence,ShowAttendance::class.java);
                startActivity(intent);
            }
        }
        else if (admin =="NO"){
            Toast.makeText(this, "Welcome to User login", Toast.LENGTH_SHORT).show();
            showAtten.setOnClickListener {
                val intent: Intent = Intent(this@Attendence,ShowAttendance::class.java);
                startActivity(intent);
            }
            setTime.setAlpha(100);
            markAtten.setAlpha(100);
            addMember.setAlpha(100);
        }

    }
}
