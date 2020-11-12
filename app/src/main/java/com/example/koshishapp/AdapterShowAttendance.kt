package com.example.koshishapp

import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.markattendancecardview.view.*
import kotlinx.android.synthetic.main.showattendancecardview.view.*
import java.lang.Exception
import java.util.*

class AdapterShowAttendance (val arrayList: List<String>, val context: Context ) :
    RecyclerView.Adapter<AdapterShowAttendance.ViewHolder>() {

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var selectedStartDate:String
        lateinit var selectedEndDate:String

        fun bindItem(model: String) {
            itemView.showAttendanceMemberName.text = model


            //Block of code which show the Date Picker Dialog, with every card view
            itemView.startDate.setOnClickListener { view ->
                val myCalendar = Calendar.getInstance()
                val year = myCalendar.get(Calendar.YEAR)
                val month = myCalendar.get(Calendar.MONTH)
                val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

                DatePickerDialog(itemView.context,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    //Toast.makeText(this,"$year-$month-$dayOfMonth",Toast.LENGTH_LONG).show()
                    selectedStartDate = "$year-${month+1}-$dayOfMonth"
                    itemView.startDate.text = selectedStartDate
                },
                    year,
                    month,
                    dayOfMonth).show()
            }

            //Block of code which show the Date Picker Dialog, with every card view
            itemView.endDate.setOnClickListener { view ->
                val myCalendar = Calendar.getInstance()
                val year = myCalendar.get(Calendar.YEAR)
                val month = myCalendar.get(Calendar.MONTH)
                val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

                DatePickerDialog(itemView.context,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        //Toast.makeText(this,"$year-$month-$dayOfMonth",Toast.LENGTH_LONG).show()
                        selectedEndDate = "$year-${month+1}-$dayOfMonth"
                        itemView.endDate.text = selectedEndDate
                    },
                    year,
                    month,
                    dayOfMonth).show()
            }

            //All Required Variable for Showing the attendance
            val showAttendanceMemberName = itemView.findViewById<TextView>(R.id.showAttendanceMemberName).text.toString()
            itemView.showAttendanceBtn.setOnClickListener {
                try {
                    Toast.makeText(itemView.context,selectedStartDate+"  "+ selectedEndDate+"  "+showAttendanceMemberName,Toast.LENGTH_LONG).show()
                    ApiCalRequest().showMemberAttendance(showAttendanceMemberName,selectedStartDate,selectedEndDate)
                }
                catch (e: Exception){
                    Toast.makeText(itemView.context,"PLEASE SELECT ALL THE REQUIRED FIELD AND DATE",Toast.LENGTH_LONG).show()
                }

            }



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.showattendancecardview,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}