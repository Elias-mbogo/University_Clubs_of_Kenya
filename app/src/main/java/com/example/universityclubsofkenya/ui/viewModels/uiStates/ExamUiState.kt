package com.example.universityclubsofkenya.ui.viewModels.uiStates

import com.example.universityclubsofkenya.data.models.ExamDetails

data class ExamUiState(
    val examDetails: List<ExamDetails> = listOf(),
)
