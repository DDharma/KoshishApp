package com.example.koshishapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_addmember.*
import java.lang.Exception


class Addmember : AppCompatActivity() {
    /*var admin:Int = 0
    var sunday:Int = 0
    var monday:Int = 0
    var tuesday:Int = 0
    var wednesday:Int = 0
    var thursday:Int = 0
    var friday:Int = 0
    var saturday:Int = 0*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addmember)

        val markButton = findViewById<Button>(R.id.mark_button);
        markButton.setOnClickListener {
            try {
                val name = findViewById<TextView>(R.id.member_name);
                val yoj = findViewById<TextView>(R.id.joining_year);
                val email = findViewById<TextView>(R.id.email);
                val phone = findViewById<TextView>(R.id.phone);
                if (phone.text.isEmpty() && phone.text.length != 10){
                    phone.error = "Please Enter You Valid Phone No"
                }
                val location = findViewById<TextView>(R.id.location);
                val admin = if (findViewById<RadioButton>(R.id.admin).isChecked){
                    1
                } else{
                    0
                }

                val respon = findViewById<TextView>(R.id.respons);
                val sunday = if (findViewById<RadioButton>(R.id.sunday).isChecked){
                    1
                }else{
                    0
                }

                val monday = if (findViewById<RadioButton>(R.id.monday).isChecked){
                    1
                }else{
                    0
                }

                val tuesday = if (findViewById<RadioButton>(R.id.tuesday).isChecked){
                    1
                }else{
                    0
                }

                val wednesday = if (findViewById<RadioButton>(R.id.wednesday).isChecked){
                    1
                }else{
                    0
                }

                val thursday = if (findViewById<RadioButton>(R.id.thursday).isChecked){
                    1
                }else{
                    0
                }

                val friday = if (findViewById<RadioButton>(R.id.friday).isChecked){
                    1
                }else{
                    0
                }

                val saturday = if (findViewById<RadioButton>(R.id.saturday).isChecked){
                    1
                }else{
                    0
                }

                ApiCalRequest().addNewMembers(this,name.text.toString(),yoj.text.toString().toInt(),email.text.toString(),phone.text.toString().toLong(),location.text.toString()
                    ,admin,respon.text.toString(),sunday,monday,tuesday,wednesday,thursday,friday,saturday)

                //Clear all the selected field
                name.text = ""
                yoj.text = ""
                email.text = ""
                phone.text = ""
                location.text = ""
                respon.text = ""
                findViewById<RadioButton>(R.id.admin).isChecked = false
                findViewById<RadioButton>(R.id.sunday).isChecked = false
                findViewById<RadioButton>(R.id.monday).isChecked = false
                findViewById<RadioButton>(R.id.tuesday).isChecked = false
                findViewById<RadioButton>(R.id.wednesday).isChecked = false
                findViewById<RadioButton>(R.id.thursday).isChecked = false
                findViewById<RadioButton>(R.id.friday).isChecked = false
                findViewById<RadioButton>(R.id.saturday).isChecked = false

            }catch (e: Exception) {
                Toast.makeText(
                    this,
                    "PLEASE SELECT ALL THE REQUIRED FIELD AND DATE",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        //Deselect all the RButton
        deselectRButton.setOnClickListener {
            findViewById<RadioButton>(R.id.admin).isChecked = false
            findViewById<RadioButton>(R.id.sunday).isChecked = false
            findViewById<RadioButton>(R.id.monday).isChecked = false
            findViewById<RadioButton>(R.id.tuesday).isChecked = false
            findViewById<RadioButton>(R.id.wednesday).isChecked = false
            findViewById<RadioButton>(R.id.thursday).isChecked = false
            findViewById<RadioButton>(R.id.friday).isChecked = false
            findViewById<RadioButton>(R.id.saturday).isChecked = false

        }
    }
}