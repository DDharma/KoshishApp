package com.example.koshishapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.markattendancecardview.view.*
import kotlinx.android.synthetic.main.showattendancecardview.view.*

class AdapterShowAttendance (val arrayList: ArrayList<ModelShowAttendance>, val context: Context ) :
    RecyclerView.Adapter<AdapterShowAttendance.ViewHolder>() {

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(model: ModelShowAttendance) {
            itemView.showAttendanceMemberName.text = model.memberName
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