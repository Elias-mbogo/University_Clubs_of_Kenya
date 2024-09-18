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
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class ScheduleViewModel(/*private val examRepository: ExamRepository*/): ViewModel() {
    var dateDialogState by mutableStateOf(false)
    var startTimeDialogState by mutableStateOf(false)
    var endTimeDialogState by mutableStateOf(false)
    var selectedDate by mutableStateOf<String?>("")
    var selectedStartTime by mutableStateOf<String?>("")
    var selectedEndTime by mutableStateOf<String?>("")

/*    suspend fun getExamDetails():Deferred<List<ExamDetails>> = coroutineScope {
        viewModelScope.async {
            examRepository.getExamDetails()
        }
    }

    //TODO: GET EXAM DETAILS
    suspend fun postAndGetExamDetails():Deferred<List<ExamDetails>> = coroutineScope {
        viewModelScope.async {
            examRepository.getExamDetails()
        }
    }*/

/*    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as UniversityClubsApplication)
                val examRepository = application.container.examRepository
                ScheduleViewModel(examRepository = examRepository)
            }
        }
    }*/
}