package com.example.universityclubsofkenya.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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

object Teacher: ClubDestinations{
    override val route: String
        get() = "teacher"
}

@Composable
fun ClubApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home.route
    ){
        composable(route = Home.route){
            Home(onStudentNavigationClicked = {navController.navigate(Student.route)},
                onPatronNavigationClicked = {navController.navigate(Teacher.route)},
                onExpertNavigationClicked = {navController.navigate(Business.route)})
        }
        composable(route = Student.route){
            StudentDomain()
        }
        composable(route = Teacher.route){
            TeacherDomain()
        }
        composable(route = Business.route){
            Business()
        }
    }

}