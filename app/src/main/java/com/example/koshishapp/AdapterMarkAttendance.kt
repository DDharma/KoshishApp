package com.example.koshishapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.markattendancecardview.view.*

class AdapterMarkAttendance (val arrayList: ArrayList<ModelMarkAttendance>, val context: Context ) :
    RecyclerView.Adapter<AdapterMarkAttendance.ViewHolder>() {

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(model: ModelMarkAttendance) {
            itemView.markAttendanceMemberName.text = model.memberName
        }
    }

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