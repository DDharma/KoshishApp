package com.example.koshishapp

import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.markattendancecardview.view.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList
import android.widget.Toast.makeText as makeText1

class AdapterMarkAttendance (val arrayList: List<String>, val context: Context ) :
    RecyclerView.Adapter<AdapterMarkAttendance.ViewHolder>() {

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var selectedDate:String
        fun bindItem(model: String) {

            itemView.markAttendanceMemberName.text = model

            //Block of code which show the Date Picker Dialog, with every card view
            itemView.markAttendanceData.setOnClickListener { view ->
            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(itemView.context,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
               //Toast.makeText(this,"$year-$month-$dayOfMonth",Toast.LENGTH_LONG).show()
               selectedDate = "$year-${month+1}-$dayOfMonth"
                itemView.markAttendanceData.text = selectedDate
                },
               year,
               month,
               dayOfMonth).show()
                    }


            //Block of code which work on the radio button
            //Retriving Ids
            val markAttendanceMemberName = itemView.findViewById<TextView>(R.id.markAttendanceMemberName).text.toString()
            val radioGrp = itemView.findViewById<RadioGroup>(R.id.markAttendanceRadioGrp)
            val radioBtn0 = itemView.findViewById<RadioButton>(R.id.markAttendanceRadioBtn0)
            val radioBtn1 = itemView.findViewById<RadioButton>(R.id.markAttendanceRadioBtn1)
            val radioBtn2 = itemView.findViewById<RadioButton>(R.id.markAttendanceRadioBtn2)
            val radioBtn3 = itemView.findViewById<RadioButton>(R.id.markAttendanceRadioBtn3)

            //Creating on click event
            itemView.markAttendanceBtn.setOnClickListener {
                if (radioGrp.checkedRadioButtonId != -1){
                    //Toast.makeText(itemView.context,"Radio Group chechker",Toast.LENGTH_LONG).show()
                    try {
                        if (radioBtn0.isChecked){
                            Toast.makeText(itemView.context,markAttendanceMemberName+" is Absent on "+ selectedDate,Toast.LENGTH_LONG).show()
                            //Adding Api call Here to send the data to Databases
                            ApiCalRequest().markMembersAttendance(markAttendanceMemberName,selectedDate,0)
                            radioGrp.clearCheck()

                        }
                        if (radioBtn1.isChecked){
                            Toast.makeText(itemView.context,markAttendanceMemberName+" is Present on "+ selectedDate,Toast.LENGTH_LONG).show()
                            //Adding Api call Here to send the data to Databases
                            ApiCalRequest().markMembersAttendance(markAttendanceMemberName,selectedDate,1)
                            radioGrp.clearCheck()
                        }
                        if (radioBtn2.isChecked){
                            Toast.makeText(itemView.context,markAttendanceMemberName+" is Informed Absent on "+selectedDate,Toast.LENGTH_LONG).show()
                            //Adding Api call Here to send the data to Databases
                            ApiCalRequest().markMembersAttendance(markAttendanceMemberName,selectedDate,2)
                            radioGrp.clearCheck()
                        }
                        if (radioBtn3.isChecked){
                            Toast.makeText(itemView.context,markAttendanceMemberName+" is Extra Present on "+selectedDate,Toast.LENGTH_LONG).show()
                            //Adding Api call Here to send the data to Databases
                            ApiCalRequest().markMembersAttendance(markAttendanceMemberName,selectedDate,3)
                            radioGrp.clearCheck()
                        }
                    }
                    catch (e:Exception){
                        Toast.makeText(itemView.context,"PLEASE SELECT ALL THE REQUIRED FIELD AND DATE",Toast.LENGTH_LONG).show()
                    }

                }
                else{
                    Toast.makeText(itemView.context,"Nothing is selected  Radio Group chechker",Toast.LENGTH_LONG).show()
                }
            }


            }
    }

    //Member for the RecyclerView Adepter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.markattendancecardview,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}