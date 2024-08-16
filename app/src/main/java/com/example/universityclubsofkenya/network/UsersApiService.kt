package com.example.universityclubsofkenya.network

import com.example.universityclubsofkenya.data.models.LoginRequest
import com.example.universityclubsofkenya.data.models.TeacherResource
import com.example.universityclubsofkenya.data.models.Users
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersApiService {
    @POST("/student-noauth")
    suspend fun getUser(@Body users: Users): Users
    @GET("/teacher")
    suspend fun getTeachersResource(): TeacherResource
    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<Unit>
}