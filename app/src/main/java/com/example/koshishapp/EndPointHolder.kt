package com.example.koshishapp

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface EndPointHolder {
    @GET("get_member_name")
    fun getMemberName():Call<ModelMemberNames>

    @POST("add_new_member")
    fun addNewMember(@Body AddMember:ModelAddMember):Call<ResponseBody>

    @POST("mark_attendance")
    fun markMemberAttendance(@Body MarkAttendance:ModelMarkAttendance):Call<String>

    @POST("set_time_table")
    fun updateTimeTable(@Body SetTimeTable:ModelSetTimeTable):Call<ResponseBody>

    @POST("show_attendance")
    fun showMemberAttendance(@Body ShowAttendance:ModelShowAttendanceSendData):Call<ModelShowAttendanceReceiveData>


}