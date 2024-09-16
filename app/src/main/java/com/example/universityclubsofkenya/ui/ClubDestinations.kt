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
import com.example.universityclubsofkenya.ui.screens.BusinessGroup
import com.example.universityclubsofkenya.ui.screens.CourseScreen
import com.example.universityclubsofkenya.ui.screens.ExamScheduleScreen
import com.example.universityclubsofkenya.ui.screens.Home
import com.example.universityclubsofkenya.ui.screens.StudentDomain
import com.example.universityclubsofkenya.ui.screens.StudentGroup
import com.example.universityclubsofkenya.ui.screens.TeacherDomain
import com.example.universityclubsofkenya.ui.viewModels.AuthenticationViewModel
import com.example.universityclubsofkenya.ui.viewModels.ExpertViewModel
import com.example.universityclubsofkenya.ui.viewModels.GroupViewModel
import com.example.universityclubsofkenya.ui.viewModels.ScheduleViewModel
import com.example.universityclubsofkenya.ui.viewModels.StudentViewModel

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

object BusinessGroupChat: ClubDestinations{
    override val route: String
        get() = "business-group"
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

object TeacherExamSchedule: ClubDestinations{
    override val route: String
        get() = "exam-schedule"
}

object StudentCourses: ClubDestinations{
    override val route: String
        get() = "student-courses"
}

object StudentGroupChat: ClubDestinations{
    override val route: String
        get() = "student-group"
}


@Composable
fun ClubApp(modifier: Modifier = Modifier,
            authenticationViewModel: AuthenticationViewModel = viewModel(factory = AuthenticationViewModel.Factory),
            expertViewModel: ExpertViewModel = viewModel(factory = ExpertViewModel.Factory),
            studentViewModel: StudentViewModel = viewModel(factory = StudentViewModel.Factory),
            groupViewModel: GroupViewModel = viewModel(factory = GroupViewModel.Factory),
            scheduleViewModel: ScheduleViewModel = viewModel()
){
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

            if (expertViewModel.expertPageState){
                LaunchedEffect(expertViewModel) {
                    expertViewModel.updateChaptersChanged(expertViewModel.getChapters().await())
                    navController.navigate(Business.route)
                    expertViewModel.expertPageState = false
                }
            }

            Home(onStudentNavigationClicked = {navController.navigate(SignIn.route)},
                onPatronNavigationClicked = { authenticationViewModel.teachersPage = it },
                teacherPageState = authenticationViewModel.teachersPage,
                expertPageState = expertViewModel.expertPageState,
                onExpertNavigationClicked = {expertViewModel.expertPageState = it})
        }
        composable(route = Student.route){
            if(studentViewModel.kenyawebCoursesPageState){
                LaunchedEffect(studentViewModel) {
                    studentViewModel.updateChaptersChanged(studentViewModel.getCourseChapters().await())
                    navController.navigate(StudentCourses.route)
                    studentViewModel.kenyawebCoursesPageState = false
                }
            }
            StudentDomain(groupViewModel= groupViewModel, navController = navController, onKenyawebCoursesPageClicked = {studentViewModel.kenyawebCoursesPageState = it},
                kenyawebCoursesPageState = studentViewModel.kenyawebCoursesPageState)
        }
        composable(route = StudentCourses.route){
            val studentUiState by studentViewModel.uiState.collectAsState()
            CourseScreen(studentUiState.chapters)
        }
        composable(route = StudentGroupChat.route){
            val groupUiState by groupViewModel.uiState.collectAsState()
            StudentGroup(groupViewModel = groupViewModel, groupMessages = groupUiState.groupMessages)
        }
        composable(route = Teacher.route){
            val authUiState by authenticationViewModel.uiState.collectAsState()
            TeacherDomain(navController, authUiState)
        }
        composable(route = TeacherExamSchedule.route){
            ExamScheduleScreen(scheduleViewModel)
        }
        composable(route = Business.route){
            val expertUiState by expertViewModel.uiState.collectAsState()
            Business(groupViewModel = groupViewModel, navController = navController,
                expertViewModel = expertViewModel, expertUiState = expertUiState)
        }
        composable(route = BusinessGroupChat.route){
            val groupUiState by groupViewModel.uiState.collectAsState()
            BusinessGroup(groupViewModel = groupViewModel, groupMessages = groupUiState.groupMessages)
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