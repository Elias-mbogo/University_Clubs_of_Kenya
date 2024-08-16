package com.example.universityclubsofkenya.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.universityclubsofkenya.ui.reusables.SignInAccount
import com.example.universityclubsofkenya.ui.screens.Business
import com.example.universityclubsofkenya.ui.screens.Home
import com.example.universityclubsofkenya.ui.screens.StudentDomain
import com.example.universityclubsofkenya.ui.screens.TeacherDomain
import com.example.universityclubsofkenya.ui.viewModels.AuthenticationViewModel

interface ClubDestinations{
    val route: String
}

object Home: ClubDestinations{
    override val route: String
        get() = "home"
}

object Business: ClubDestinations{
    override val route: String
        get() = "business"
}

object BusinessParticipant: ClubDestinations{
    override val route: String
        get() = "businessParticipant"
}

object Student: ClubDestinations{
    override val route: String
        get() = "student"
}

object SignIn: ClubDestinations{
    override val route: String
        get() = "sign-in"
}

object Teacher: ClubDestinations{
    override val route: String
        get() = "teacher"
}

@Composable
fun ClubApp(modifier: Modifier = Modifier, authenticationViewModel: AuthenticationViewModel = viewModel(factory = AuthenticationViewModel.Factory) ){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home.route
    ){
        composable(route = Home.route){
            if (authenticationViewModel.teachersPage){
                LaunchedEffect(authenticationViewModel) {
                    authenticationViewModel.updateTeacherResourceChanged(authenticationViewModel.getTeachersResource().await())
                    navController.navigate(Teacher.route)
                    authenticationViewModel.teachersPage = false
                }
            }
            Home(onStudentNavigationClicked = {navController.navigate(SignIn.route)},
                onPatronNavigationClicked = { authenticationViewModel.teachersPage = it },
                teacherPageState = authenticationViewModel.teachersPage,
                onExpertNavigationClicked = {navController.navigate(Business.route)})
        }
        composable(route = Student.route){
            StudentDomain()
        }
        composable(route = Teacher.route){
            val authUiState by authenticationViewModel.uiState.collectAsState()
            TeacherDomain(authUiState)
        }
        composable(route = Business.route){
            Business()
        }
        composable(route = SignIn.route){
            if (authenticationViewModel.signInPost){
                LaunchedEffect(authenticationViewModel) {
                    authenticationViewModel.usersResult = authenticationViewModel.postUser().await()
                }
                navController.navigate(Student.route)
                authenticationViewModel.signInPost = false
            }
            SignInAccount(
                username = authenticationViewModel.username,
                onUsernameChanged = {authenticationViewModel.updateUsernameChanged(it)},
                password = authenticationViewModel.password,
                onPasswordChanged = {authenticationViewModel.updatePasswordChanged(it)},
                onUsersStateChanged = {authenticationViewModel.signInPost = it},
                userDetails = authenticationViewModel.signInPost
            )
        }
    }

}