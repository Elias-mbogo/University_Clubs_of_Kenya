package com.example.universityclubsofkenya.network

import com.example.universityclubsofkenya.data.models.ChapterName
import retrofit2.http.GET
import retrofit2.http.POST

interface CourseApiService {
    @GET("/chapters")
    suspend fun getChapters(): List<ChapterName>
    @POST("/chapter-add")
    suspend fun addAndGetChapters(chapterName: ChapterName): List<ChapterName>
}