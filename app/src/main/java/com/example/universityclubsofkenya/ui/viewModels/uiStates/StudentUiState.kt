package com.example.universityclubsofkenya.ui.viewModels.uiStates

import com.example.universityclubsofkenya.data.models.ChapterName

data class StudentUiState(
    val chapters: List<ChapterName> = emptyList(),
)
