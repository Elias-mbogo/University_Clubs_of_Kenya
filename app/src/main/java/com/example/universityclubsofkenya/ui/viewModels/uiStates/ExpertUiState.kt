package com.example.universityclubsofkenya.ui.viewModels.uiStates

import com.example.universityclubsofkenya.data.models.ChapterName

data class ExpertUiState(
    val chapters: List<ChapterName> = emptyList()
)
