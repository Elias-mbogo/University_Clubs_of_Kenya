package com.example.universityclubsofkenya.network

import com.example.universityclubsofkenya.data.models.Usersz
import retrofit2.http.Body
import retrofit2.http.POST

interface UsersApiService {
    @POST("/student-noauth")
    suspend fun getUser(@Body users: Usersz): Usersz
}