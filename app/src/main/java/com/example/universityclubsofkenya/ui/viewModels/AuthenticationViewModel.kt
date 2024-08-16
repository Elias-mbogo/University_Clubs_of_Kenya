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
import com.example.universityclubsofkenya.data.models.TeacherResource
import com.example.universityclubsofkenya.data.models.Users
import com.example.universityclubsofkenya.data.repositories.UsersRepository
import com.example.universityclubsofkenya.ui.viewModels.uiStates.AuthUiState
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthenticationViewModel(private val usersRepository: UsersRepository): ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()


    var username by mutableStateOf("")
    var password by mutableStateOf("")

    var res = TeacherResource("")


    var signInPost by mutableStateOf(false)
    var teachersPage by mutableStateOf(false)


    fun updateUsernameChanged(user: String){
        username = user
    }
    fun updatePasswordChanged(pass: String){
        password = pass
    }

    fun updateTeacherResourceChanged(res: TeacherResource){
        _uiState.value = AuthUiState(currentCompanyName = res.companyName)
    }

    var usersResult = Users("", "", false)

    suspend fun postUser(): Deferred<Users> = coroutineScope {
        val newUsers = Users( username, password, true)

        viewModelScope.async {
            usersRepository.getUsers(newUsers)
        }
    }

    suspend fun getTeachersResource(): Deferred<TeacherResource> = coroutineScope {
        viewModelScope.async {
            usersRepository.getTeachersResource()
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as UniversityClubsApplication)
                val usersRepository = application.container.usersRepository
                AuthenticationViewModel(usersRepository = usersRepository)
            }
        }
    }

}