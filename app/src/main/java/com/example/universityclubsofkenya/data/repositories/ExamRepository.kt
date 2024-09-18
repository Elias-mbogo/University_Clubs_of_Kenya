package com.example.universityclubsofkenya.data.repositories

import com.example.universityclubsofkenya.data.models.ExamDetails
import com.example.universityclubsofkenya.network.ExamApiService

interface ExamRepository {
    suspend fun getExamDetails(): List<ExamDetails>
    suspend fun postAndGetExamDetails(examDetails: ExamDetails): List<ExamDetails>

}

class NetworkExamRepository(val examApiService: ExamApiService): ExamRepository{
    override suspend fun getExamDetails(): List<ExamDetails> = examApiService.getExamDetails()

    override suspend fun postAndGetExamDetails(examDetails: ExamDetails): List<ExamDetails> {
        return examApiService.postAndGetExamDetails(examDetails)
    }
}