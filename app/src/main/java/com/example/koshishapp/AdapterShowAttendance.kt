package com.example.koshishapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.markattendancecardview.view.*
import kotlinx.android.synthetic.main.showattendancecardview.view.*
import java.lang.Exception
import java.util.*

class AdapterShowAttendance (val arrayList: List<String>, private val context: Context ) :
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
                    //val attendanceReceivedData = ApiCalRequest().showMemberAttendance(showAttendanceMemberName,selectedStartDate,selectedEndDate).value
                    //Log.e("Data",attendanceReceivedData!!.ABSENT.toString())

                    ApiCalRequest().showMemberAttendance(showAttendanceMemberName,selectedStartDate,selectedEndDate).observe(itemView.context as LifecycleOwner,
                        androidx.lifecycle.Observer{attendanceReceivedData ->
                            Log.e("Data",attendanceReceivedData.toString())
                            AlertDialog.Builder(itemView.context)
                                .setTitle("ATTENDANCE OF ${attendanceReceivedData.NAME} DATE FROM ${attendanceReceivedData.START_DATE} TO ${attendanceReceivedData.END_DATE}")
                                .setMessage(
                                    "ABSENT = ${attendanceReceivedData.ABSENT}\n" +
                                            "PRESENT = ${attendanceReceivedData.PRESENT}\n" +
                                            "EXTRA-PRESENT =${attendanceReceivedData.EXTRA_PRESENT}\n" +
                                            "INFORMED-ABSENT =${attendanceReceivedData.INFORMED_ABSENT}\n" +
                                            "TOTAL NO OF TURNS ${attendanceReceivedData.TOTAL_NO_OF_TURN}")
                                .setPositiveButton("OK") { _, _ ->
                                }
                                .setCancelable(false).show()
                    })


                }
                catch (e: Exception){
                    Log.e("error",e.message.toString())
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