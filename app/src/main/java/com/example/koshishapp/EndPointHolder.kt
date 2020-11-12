package com.example.koshishapp

import retrofit2.Call
import retrofit2.http.*

interface EndPointHolder {
    @GET("get_member_name")
    fun getMemberName():Call<ModelMemberNames>

    @POST("mark_attendance")
    fun markMemberAttendance(@Body MarkAttendance:ModelMarkAttendance):Call<String>

    @POST("show_attendance")
    fun showMemberAttendance(@Body ShowAttendance:ModelShowAttendanceSendData):Call<ModelShowAttendanceReceiveData>


}