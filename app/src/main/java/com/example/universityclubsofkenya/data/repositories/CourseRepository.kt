package com.example.universityclubsofkenya.data.repositories

import com.example.universityclubsofkenya.data.models.ChapterName
import com.example.universityclubsofkenya.network.CourseApiService

interface CourseRepository {
    suspend fun getChapters(): List<ChapterName>
    suspend fun addAndGetChapters(chapterName: ChapterName): List<ChapterName>
}

class NetworkCourseRepository(private val courseApiService: CourseApiService): CourseRepository {
    override suspend fun getChapters(): List<ChapterName> {
        return courseApiService.getChapters()
    }
    override suspend fun addAndGetChapters(chapterName: ChapterName): List<ChapterName> {
        return courseApiService.addAndGetChapters(chapterName)
    }
}