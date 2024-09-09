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
import com.example.universityclubsofkenya.data.models.ChapterName
import com.example.universityclubsofkenya.data.repositories.CourseRepository
import com.example.universityclubsofkenya.ui.viewModels.uiStates.StudentUiState
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class StudentViewModel(val courseRepository: CourseRepository): ViewModel() {

    private val _uiState = MutableStateFlow(StudentUiState())
    val uiState: StateFlow<StudentUiState> = _uiState.asStateFlow()

    var studentPageState by mutableStateOf(false)
    var kenyawebCoursesPageState by mutableStateOf(false)

    fun updateChaptersChanged(res: List<ChapterName>){
        _uiState.value = StudentUiState(chapters = res)
    }

    suspend fun getCourseChapters(): Deferred<List<ChapterName>> = coroutineScope {
        viewModelScope.async { courseRepository.getChapters() }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as UniversityClubsApplication)
                val courseRepository = application.container.courseRepository
                StudentViewModel(courseRepository = courseRepository)
            }
        }
    }
}