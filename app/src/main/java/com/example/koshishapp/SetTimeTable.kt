package com.example.koshishapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_mark_attendance.*
import kotlinx.android.synthetic.main.activity_set_time_table.*
import java.lang.Exception

class SetTimeTable : AppCompatActivity() {
    var sunday:Int = 0
    var monday:Int = 0
    var tuesday:Int = 0
    var wednesday:Int = 0
    var thursday:Int = 0
    var friday:Int = 0
    var saturday:Int = 0
    lateinit var name:String
    lateinit var option:Spinner
    lateinit var options:List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_time_table)

        option = findViewById<Spinner>(R.id.set_member_name)

        //Calling Get Member Api To get the Member Name from DataBase
        ApiCalRequest().memberNames()!!.observe(this, androidx.lifecycle.Observer{

            val myAdapter = AdapterMarkAttendance(it.member_data_json,this)
            //markAttendanceRecyclerview.layoutManager = LinearLayoutManager(this)
            //markAttendanceRecyclerview.adapter = myAdapter
            //options = myAdapter.arrayList
            option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myAdapter.arrayList)
        })


        //var options = arrayOf("DHARMVIR","Rupali","PRNAKUL")
        //option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        option.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                name = options[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.e("Error","Nothing es selected")
            }

        }


        sunday = if (findViewById<RadioButton>(R.id.set_sunday).isChecked){
            1
        }else{
            0
        }

        monday = if (findViewById<RadioButton>(R.id.set_monday).isChecked){
            1
        }else{
            0
        }

        tuesday = if (findViewById<RadioButton>(R.id.set_tuesday).isChecked){
            1
        }else{
            0
        }

        wednesday = if (findViewById<RadioButton>(R.id.set_wednesday).isChecked){
            1
        }else{
            0
        }

        thursday = if (findViewById<RadioButton>(R.id.set_thursday).isChecked){
            1
        }else{
            0
        }

        friday = if (findViewById<RadioButton>(R.id.set_friday).isChecked){
            1
        }else{
            0
        }

        saturday = if (findViewById<RadioButton>(R.id.set_saturday).isChecked){
            1
        }else{
            0
        }

        set_mark_button.setOnClickListener {
            try {
                ApiCalRequest().updateMemberTimeTable(name,sunday,monday,tuesday,wednesday,thursday,friday,saturday)
            }catch (e:Exception){
                Toast.makeText(
                    this,
                    "PLEASE SELECT ALL THE REQUIRED FIELD AND DATE",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

    }
}