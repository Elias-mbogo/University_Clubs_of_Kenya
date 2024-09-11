package com.example.universityclubsofkenya.network

import com.example.universityclubsofkenya.data.models.GroupMessage
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface GroupApiService {
    @GET("/student-messages")
    suspend fun getStudentChats(): List<GroupMessage>
    @POST("/student-messages-add")
    suspend fun postAndGetStudentChats(@Body groupMessage: GroupMessage): List<GroupMessage>

}