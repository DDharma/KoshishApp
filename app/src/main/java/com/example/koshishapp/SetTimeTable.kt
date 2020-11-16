package com.example.koshishapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_mark_attendance.*
import kotlinx.android.synthetic.main.activity_set_time_table.*
import java.lang.Exception

class SetTimeTable : AppCompatActivity() {
    /*var sunday:Int = 0
    var monday:Int = 0
    var tuesday:Int = 0
    var wednesday:Int = 0
    var thursday:Int = 0
    var friday:Int = 0
    var saturday:Int = 0*/
    var name:String = ""
    lateinit var option:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_time_table)

        val progressBar2 = ProgressDialog(this)
        progressBar2.setMessage("Loading the Content ... ")
        progressBar2.setCancelable(false)
        progressBar2.show()
        Handler().postDelayed({progressBar2.dismiss()},5000)

        option = findViewById<Spinner>(R.id.set_member_name)

        //Calling Get Member Api To get the Member Name from DataBase
        ApiCalRequest().memberNames()!!.observe(this, androidx.lifecycle.Observer{

            val myAdapter = AdapterMarkAttendance(it.member_data_json,this)
            //markAttendanceRecyclerview.layoutManager = LinearLayoutManager(this)
            //markAttendanceRecyclerview.adapter = myAdapter
            //options = myAdapter.arrayList
            option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,it.member_data_json)
            option.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    name = it.member_data_json[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Log.e("Error","Nothing es selected")
                }

            }
        })


        set_mark_button.setOnClickListener {
            try {
                val sunday = if (findViewById<RadioButton>(R.id.set_sunday).isChecked){
                    1
                }else{
                    0
                }

                val monday = if (findViewById<RadioButton>(R.id.set_monday).isChecked){
                    1
                }else{
                    0
                }

                val tuesday = if (findViewById<RadioButton>(R.id.set_tuesday).isChecked){
                    1
                }else{
                    0
                }

                val wednesday = if (findViewById<RadioButton>(R.id.set_wednesday).isChecked){
                    1
                }else{
                    0
                }

                val thursday = if (findViewById<RadioButton>(R.id.set_thursday).isChecked){
                    1
                }else{
                    0
                }

                val friday = if (findViewById<RadioButton>(R.id.set_friday).isChecked){
                    1
                }else{
                    0
                }

                val saturday = if (findViewById<RadioButton>(R.id.set_saturday).isChecked){
                    1
                }else{
                    0
                }
                ApiCalRequest().updateMemberTimeTable(this,name,sunday,monday,tuesday,wednesday,thursday,friday,saturday)


                findViewById<RadioButton>(R.id.set_saturday).isChecked = false;
                findViewById<RadioButton>(R.id.set_monday).isChecked = false
                findViewById<RadioButton>(R.id.set_tuesday).isChecked = false
                findViewById<RadioButton>(R.id.set_wednesday).isChecked = false
                findViewById<RadioButton>(R.id.set_thursday).isChecked = false
                findViewById<RadioButton>(R.id.set_friday).isChecked = false
                findViewById<RadioButton>(R.id.set_sunday).isChecked = false

            }catch (e:Exception){
                Toast.makeText(
                    this,
                    "PLEASE SELECT ALL THE REQUIRED FIELD AND DATE",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

        //Deselect all the RButton
        deselectRButton1.setOnClickListener {
            findViewById<RadioButton>(R.id.set_saturday).isChecked = false;
            findViewById<RadioButton>(R.id.set_monday).isChecked = false
            findViewById<RadioButton>(R.id.set_tuesday).isChecked = false
            findViewById<RadioButton>(R.id.set_wednesday).isChecked = false
            findViewById<RadioButton>(R.id.set_thursday).isChecked = false
            findViewById<RadioButton>(R.id.set_friday).isChecked = false
            findViewById<RadioButton>(R.id.set_sunday).isChecked = false
        }
    }
}