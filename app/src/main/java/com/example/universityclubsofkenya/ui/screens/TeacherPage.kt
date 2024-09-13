package com.example.universityclubsofkenya.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.R
import com.example.universityclubsofkenya.ui.reusables.Portal
import com.example.universityclubsofkenya.ui.theme.UniversityClubsOfKenyaTheme
import com.example.universityclubsofkenya.ui.viewModels.uiStates.AuthUiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeacherDomain(companyTrial: AuthUiState, modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    val datePickerState = rememberDatePickerState()
    Column (modifier = modifier
        .padding(vertical = 20.dp)
        .verticalScroll(scrollState)){
//        Portal()
        TeacherBusinessRelations(companyTrial)
        CalendarMonth(datePickerState)
        CalendarSystem()

    }
}

@Composable
fun TeacherBusinessRelations(companyTrial: AuthUiState, modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(vertical = 10.dp, horizontal = 10.dp)){
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Image(painter = painterResource(R.drawable.safaricom),
                contentDescription = "safaricom",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape))
            Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
                Column (modifier = modifier
                    .padding(10.dp)){
                    Column{
                        Text(text = companyTrial.currentCompanyName)
                    }
                    Text(text = "Tests: 5")
                }
                Column(modifier = modifier.padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Schedule")
                    }
                }
            }
        }

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Image(painter = painterResource(R.drawable.kenyaweb),
                contentDescription = "kenyaweb",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape))
            Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
                Column (modifier = modifier
                    .padding(10.dp)){
                    Column{
                        Text(text = "KENYAWEB")
                    }
                    Text(text = "Tests: 7")
                }
                Column(modifier = modifier.padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Schedule")
                    }
                }
            }
        }

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Image(painter = painterResource(R.drawable.presta),
                contentDescription = "presta",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape))
            Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
                Column (modifier = modifier
                    .padding(10.dp)){
                    Column{
                        Text(text = "PRESTA")
                    }
                    Text(text = "Tests: 10")
                }
                Column(modifier = modifier.padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Schedule")
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarSystem(modifier: Modifier = Modifier){

    Column(modifier = modifier.padding(10.dp)){
        Card {
            Column(modifier = modifier
                .padding(10.dp)) {

                Text(text = "SCHEDULE:")
                Spacer(modifier = modifier.padding(7.dp))
                TeachersSchedule()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarMonth(datePickerState: DatePickerState, modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(10.dp)){
        DatePicker(state = datePickerState, showModeToggle = true)
    }
}


@Composable
fun TeachersSchedule(modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(10.dp)) {
        Text(text = "TODO://")
        Spacer(modifier = modifier.padding(10.dp))
        HorizontalDivider()
        Spacer(modifier = modifier.padding(10.dp))
        HorizontalDivider()
        Spacer(modifier = modifier.padding(10.dp))
        HorizontalDivider()
        Spacer(modifier = modifier.padding(10.dp))
        HorizontalDivider()
        Spacer(modifier = modifier.padding(10.dp))
        HorizontalDivider()
    }
}

/*
@Preview(showBackground = true)
@Composable
fun TeacherPagePreview() {
    UniversityClubsOfKenyaTheme {
        TeacherDomain()
    }
}*/
