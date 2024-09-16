package com.example.universityclubsofkenya.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ScheduleViewModel: ViewModel() {
    var dateDialogState by mutableStateOf(false)
    var timeDialogState by mutableStateOf(false)
}