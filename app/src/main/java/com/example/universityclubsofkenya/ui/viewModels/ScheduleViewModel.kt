package com.example.universityclubsofkenya.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.universityclubsofkenya.UniversityClubsApplication
import com.example.universityclubsofkenya.data.models.ExamDetails
import com.example.universityclubsofkenya.data.repositories.ExamRepository
import com.example.universityclubsofkenya.ui.viewModels.uiStates.ExamUiState
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScheduleViewModel(private val examRepository: ExamRepository): ViewModel() {
    private val _uiState = MutableStateFlow(ExamUiState())
    val uiState: StateFlow<ExamUiState> = _uiState.asStateFlow()

    var dateDialogState by mutableStateOf(false)
    var startTimeDialogState by mutableStateOf(false)
    var endTimeDialogState by mutableStateOf(false)
    var examState by mutableStateOf(false)

    var selectedDate by mutableStateOf<String?>("")
    var selectedStartTime by mutableStateOf<String?>("")
    var selectedEndTime by mutableStateOf<String?>("")

    var examName by mutableStateOf("")

    fun updateExamName(name: String){
        examName = name
    }

    fun updateExamDetailsChanged(res: List<ExamDetails>){
        _uiState.value = ExamUiState(examDetails = res)
    }

    suspend fun getExamDetails(): Deferred<List<ExamDetails>> = coroutineScope {
        viewModelScope.async {
            examRepository.getExamDetails()
        }
    }

    suspend fun postAndGetExamDetails():Deferred<List<ExamDetails>> = coroutineScope {
        val examDetails = ExamDetails(date = selectedDate!!, startTime = selectedStartTime!!, endTime = selectedEndTime!!, examName = examName, businessId = 2)

        viewModelScope.async {
            examRepository.postAndGetExamDetails(examDetails)
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as UniversityClubsApplication)
                val examRepository = application.container.examRepository
                ScheduleViewModel(examRepository = examRepository)
            }
        }
    }
}