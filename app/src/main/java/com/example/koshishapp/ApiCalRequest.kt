package com.example.koshishapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCalRequest {
    lateinit var memberReturnData:MutableLiveData<ModelMemberNames>
    val retrofit = Retrofit.Builder()
        .baseUrl("https://049f3d3603ae.ngrok.io/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()
    val apiEndPointHolder = retrofit.create(EndPointHolder::class.java)

    fun memberNames():LiveData<ModelMemberNames>?{
        memberReturnData = MutableLiveData<ModelMemberNames>()
        /*val retrofit = Retrofit.Builder()
            .baseUrl("https://049f3d3603ae.ngrok.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiEndPointHolder = retrofit.create(EndPointHolder::class.java)*/

        apiEndPointHolder.getMemberName().enqueue(object:Callback<ModelMemberNames>{
            override fun onResponse(
                call: Call<ModelMemberNames>,
                response: Response<ModelMemberNames>
            ) {
                Log.e("Responce",response.body().toString())
                memberReturnData!!.postValue(response.body())

            }

            override fun onFailure(call: Call<ModelMemberNames>, t: Throwable) {
                Log.e("Error",t.message)
            }

        })

        return memberReturnData
    }

    fun markMembersAttendance(NAME:String, DATE:String, VALUE:Int){
        val objModelMarkAttendance = ModelMarkAttendance(NAME,DATE, VALUE)
        apiEndPointHolder.markMemberAttendance(objModelMarkAttendance).enqueue(object:Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.e("aklfhalskfhskfa",response.body().toString())
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("error",t.message.toString())

            }

        })
    }

    fun showMemberAttendance(NAME: String,START_DATE:String,END_DATE:String){
        val oblModelShowAttendance = ModelShowAttendanceSendData(NAME, START_DATE, END_DATE)
        apiEndPointHolder.showMemberAttendance(oblModelShowAttendance).enqueue(object:Callback<ModelShowAttendanceReceiveData>{
            override fun onResponse(
                call: Call<ModelShowAttendanceReceiveData>,
                response: Response<ModelShowAttendanceReceiveData>
            ) {
                Log.e("responce",response.body().toString())
            }

            override fun onFailure(call: Call<ModelShowAttendanceReceiveData>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

        })
    }
}