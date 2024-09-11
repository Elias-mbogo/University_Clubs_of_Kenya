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
import com.example.universityclubsofkenya.ui.viewModels.uiStates.ExpertUiState
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExpertViewModel(private val courseRepository: CourseRepository): ViewModel() {

    private val _uiState = MutableStateFlow(ExpertUiState())
    val uiState: StateFlow<ExpertUiState> = _uiState.asStateFlow()

    var chapter by mutableStateOf("")

    var expertPageState by mutableStateOf(false)
    var newChapterState by mutableStateOf(false)


    fun onChapterDetailsChanged(ch: String){
        chapter = ch
    }

    fun updateChaptersChanged(res: List<ChapterName>){
        _uiState.value = ExpertUiState(chapters = res)
    }

    suspend fun getChapters(): Deferred<List<ChapterName>> = coroutineScope {
        viewModelScope.async {
            courseRepository.getChapters()
        }
    }

    suspend fun addChapters(): Deferred<List<ChapterName>> = coroutineScope {
        viewModelScope.async {
            courseRepository.addAndGetChapters(ChapterName(chapter))
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as UniversityClubsApplication)
                val courseRepository = application.container.courseRepository
                ExpertViewModel(courseRepository = courseRepository)
            }
        }
    }
}