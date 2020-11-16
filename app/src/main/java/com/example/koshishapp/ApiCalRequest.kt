package com.example.koshishapp

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCalRequest {
    lateinit var memberReturnData:MutableLiveData<ModelMemberNames>
    //lateinit var attendanceData:MutableLiveData<ModelShowAttendanceReceiveData>
    val retrofit = Retrofit.Builder()
        .baseUrl("https://cc7b0fdf5961.ngrok.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiEndPointHolder = retrofit.create(EndPointHolder::class.java)

    fun memberNames():LiveData<ModelMemberNames>?{
        memberReturnData = MutableLiveData<ModelMemberNames>()
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

    fun addNewMembers(context:Context,NAME:String, YEAR_OF_JOINING:Int, EMAIL:String, PHONE:Long, LOCATION:String, IS_ADMIN:Int, RESPONSIBILITY:String,
                      SUNDAY:Int, MONDAY:Int, TUESDAY:Int, WEDNESDAY:Int, THURSDAY:Int, FRIDAY:Int,SATURDAY:Int){
        val objAddMember = ModelAddMember(NAME, YEAR_OF_JOINING, EMAIL, PHONE, LOCATION, IS_ADMIN, RESPONSIBILITY,
            SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY)
        apiEndPointHolder.addNewMember(objAddMember).enqueue(object:Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.e("AddNewMember",response.body()!!.string())
                Toast.makeText(context,"Value_Added",Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("error",t.message.toString())
            }
        })
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

    fun showMemberAttendance(NAME: String,START_DATE:String,END_DATE:String):LiveData<ModelShowAttendanceReceiveData>{
        val attendanceData = MutableLiveData<ModelShowAttendanceReceiveData>()
        val oblModelShowAttendance = ModelShowAttendanceSendData(NAME, START_DATE, END_DATE)
        apiEndPointHolder.showMemberAttendance(oblModelShowAttendance).enqueue(object:Callback<ModelShowAttendanceReceiveData>{
            override fun onResponse(
                call: Call<ModelShowAttendanceReceiveData>,
                response: Response<ModelShowAttendanceReceiveData>
            ) {
                Log.e("responce",response.body().toString())
                attendanceData!!.postValue(response.body())
            }

            override fun onFailure(call: Call<ModelShowAttendanceReceiveData>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

        })
        return attendanceData
    }

    fun updateMemberTimeTable(context: Context,NAME:String, SUNDAY:Int, MONDAY:Int, TUESDAY:Int, WEDNESDAY:Int, THURSDAY:Int, FRIDAY:Int,SATURDAY:Int){
        val objModelSetTimeTable = ModelSetTimeTable(NAME, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY)

        apiEndPointHolder.updateTimeTable(objModelSetTimeTable).enqueue(object:Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.e("Set Time Table",response.body()!!.string())
                Toast.makeText(context,"Time Table Updated",Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

        })
    }

}