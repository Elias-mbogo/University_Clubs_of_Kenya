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
import com.example.universityclubsofkenya.data.models.GroupMessage
import com.example.universityclubsofkenya.data.repositories.GroupRepository
import com.example.universityclubsofkenya.ui.viewModels.uiStates.GroupUiState
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GroupViewModel(private val groupRepository: GroupRepository): ViewModel() {
    private val _uiState = MutableStateFlow(GroupUiState())
    val uiState: StateFlow<GroupUiState> = _uiState.asStateFlow()
    //student group state
    var studentGroupPageState by mutableStateOf(false)
    //business group state
    var businessGroupPageState by mutableStateOf(false)

    fun updateStudentChatsChanged(res: List<GroupMessage>){
        _uiState.value = GroupUiState(groupMessages = res)
    }

    fun updateExpertChatsChanged(res: List<GroupMessage>){
        _uiState.value = GroupUiState(groupMessages = res)
    }

    suspend fun getStudentChats(): Deferred<List<GroupMessage>> = coroutineScope {
        viewModelScope.async {
            groupRepository.getStudentChats()
        }
    }

    suspend fun postAndGetStudentChats(groupMessage: GroupMessage): Deferred<List<GroupMessage>> = coroutineScope {
        viewModelScope.async {
            groupRepository.postAndGetStudentChats(groupMessage)
        }
    }

    suspend fun getExpertChats(): Deferred<List<GroupMessage>> = coroutineScope {
        viewModelScope.async {
            groupRepository.getExpertChats()
        }
    }

    suspend fun postAndGetExpertChats(groupMessage: GroupMessage): Deferred<List<GroupMessage>> = coroutineScope {
        viewModelScope.async {
            groupRepository.postAndGetExpertChats(groupMessage)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory{
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as UniversityClubsApplication)
                val groupRepository = application.container.groupRepository
                GroupViewModel(groupRepository = groupRepository)
            }
        }
    }
}