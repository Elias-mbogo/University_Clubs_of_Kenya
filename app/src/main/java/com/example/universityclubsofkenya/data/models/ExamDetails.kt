package com.example.universityclubsofkenya.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ExamDetails(
    val date: String,
    val startTime: String,
    val endTime: String,
    val examName: String,
    val businessId: Int
)
