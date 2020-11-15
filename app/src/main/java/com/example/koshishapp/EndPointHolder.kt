package com.example.koshishapp

import retrofit2.Call
import retrofit2.http.*

interface EndPointHolder {
    @GET("get_member_name")
    fun getMemberName():Call<ModelMemberNames>

    @POST("add_new_member")
    fun addNewMember(@Body AddMember:ModelAddMember):Call<String>

    @POST("mark_attendance")
    fun markMemberAttendance(@Body MarkAttendance:ModelMarkAttendance):Call<String>

    @POST("set_time_table")
    fun updateTimeTable(@Body SetTimeTable:ModelSetTimeTable):Call<String>

    @POST("show_attendance")
    fun showMemberAttendance(@Body ShowAttendance:ModelShowAttendanceSendData):Call<ModelShowAttendanceReceiveData>


}