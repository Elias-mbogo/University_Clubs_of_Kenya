package com.example.universityclubsofkenya.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.R
import com.example.universityclubsofkenya.ui.theme.Typography

@Composable
fun Home(onStudentNavigationClicked: () -> Unit,
         onPatronNavigationClicked: () -> Unit,
         onExpertNavigationClicked: () -> Unit,
         modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    
    Column(modifier = modifier.verticalScroll(scrollState)) {
        AppTitle()
        Student(onStudentButtonClicked = onStudentNavigationClicked)
        Patron(onPatronButtonClicked = onPatronNavigationClicked)
        Expert(onExpertButtonClicked = onExpertNavigationClicked)
    }
}

@Composable
fun AppTitle(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(30.dp)
        .size(150.dp)){
        ElevatedCard(onClick = { /*TODO*/ }) {
            Column(modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 20.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "UNIVERSITY CLUBS",  style = Typography.titleLarge )
                Text(text = "OF KENYA", style = Typography.titleLarge)
                Spacer(modifier = modifier.padding(10.dp))
                Text(text = "A social platform that aims to strengthen",
                    style = Typography.bodySmall)
                Text(text = "ties of students in universities ",
                    style = Typography.bodySmall)
                Text(text = "with the kenyan industries.",
                    style = Typography.bodySmall)
                Spacer(modifier = modifier.padding(10.dp))
            }

        }
    }

}

@Composable
fun Student(onStudentButtonClicked: () -> Unit, modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 20.dp)){
        Button(onClick = onStudentButtonClicked ) {
            Text(text = "Student Member")
        }
        Image(painter = painterResource(id = R.drawable.student_club1),
            contentDescription = "Student Clubs",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .size(200.dp)
                .clip(RoundedCornerShape(64.dp)))
        Spacer(modifier = modifier.padding(5.dp))
        Text(text = "Students enroll to universities primarily to study and search for opportunities in the workforce when they are through with their studies.",
        style = Typography.bodyMedium)
        Spacer(modifier = modifier.padding(5.dp))
        Text(text = "Clubs can best facilitate the necessary connections needed for the students to engage with the industries at large in the course of their study.",
        style = Typography.bodyMedium)
        Spacer(modifier = modifier.padding(5.dp))

    }
}

@Composable
fun Patron(onPatronButtonClicked: () -> Unit, modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 20.dp)){
        Button(onClick = onPatronButtonClicked) {
            Text(text = "Lecturer Patron")
        }
        Image(painter = painterResource(id = R.drawable.teacher_club1),
            contentDescription = "Patron Clubs",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .size(200.dp)
                .clip(RoundedCornerShape(64.dp)))
        Spacer(modifier = modifier.padding(5.dp))
        Text(text = "Students enroll to universities primarily to study and search for opportunities in the workforce when they are through with their studies.",
            style = Typography.bodyMedium)
        Spacer(modifier = modifier.padding(5.dp))
        Text(text = "Clubs can best facilitate the necessary connections needed for the students to engage with the industries at large in the course of their study.",
            style = Typography.bodyMedium)
        Spacer(modifier = modifier.padding(5.dp))

    }
}

@Composable
fun Expert(onExpertButtonClicked: () -> Unit, modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 20.dp)){
        Button(onClick = onExpertButtonClicked) {
            Text(text = "Industry Expert")
        }
        Image(painter = painterResource(id = R.drawable.business_club1),
            contentDescription = "Expert Clubs",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .size(200.dp)
                .clip(RoundedCornerShape(64.dp)))
        Spacer(modifier = modifier.padding(5.dp))
        Text(text = "Students enroll to universities primarily to study and search for opportunities in the workforce when they are through with their studies.",
            style = Typography.bodyMedium)
        Spacer(modifier = modifier.padding(5.dp))
        Text(text = "Clubs can best facilitate the necessary connections needed for the students to engage with the industries at large in the course of their study.",
            style = Typography.bodyMedium)
        Spacer(modifier = modifier.padding(5.dp))
    }
}

/*
@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    UniversityClubsOfKenyaTheme {
        Home()
    }
}*/
