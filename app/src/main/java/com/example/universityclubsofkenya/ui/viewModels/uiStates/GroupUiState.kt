package com.example.universityclubsofkenya.ui.viewModels.uiStates

import com.example.universityclubsofkenya.data.models.GroupMessage

data class GroupUiState(
    val groupMessages: List<GroupMessage> = emptyList()
)
