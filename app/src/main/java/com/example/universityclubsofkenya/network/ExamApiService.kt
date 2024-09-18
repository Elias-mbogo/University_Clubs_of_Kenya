package com.example.universityclubsofkenya.network

import com.example.universityclubsofkenya.data.models.ExamDetails
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ExamApiService {
    @GET("/exams")
    suspend fun getExamDetails(): List<ExamDetails>

    @POST("/exams-add")
    suspend fun postAndGetExamDetails(@Body examDetails: ExamDetails): List<ExamDetails>
}