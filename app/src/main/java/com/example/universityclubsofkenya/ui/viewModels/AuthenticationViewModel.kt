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
import com.example.universityclubsofkenya.data.models.Usersz
import com.example.universityclubsofkenya.data.repositories.UserszRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class AuthenticationViewModel(private val usersRepository: UserszRepository): ViewModel() {

    var username by mutableStateOf("")
    var password by mutableStateOf("")

    var signInPost by mutableStateOf(false)

    fun updateUsernameChanged(user: String){
        username = user
    }
    fun updatePasswordChanged(pass: String){
        password = pass
    }

    var usersResult = Usersz(null,"", "", false)

    suspend fun postUser(): Deferred<Usersz> = coroutineScope {
        val newUsers = Usersz(null, username, password, true)

        viewModelScope.async {
            usersRepository.getUsers(newUsers)
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