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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
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

@Composable
fun TeacherDomain(companyTrial: AuthUiState, modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    Column (modifier = modifier
        .padding(vertical = 20.dp)
        .verticalScroll(scrollState)){
        Portal()
        TeacherBusinessRelations(companyTrial)
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

@Composable
fun CalendarSystem(modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(10.dp)){
        Card {
            Column(modifier = modifier
                .padding(10.dp)) {
                Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(text = "YEAR: 2024")
                }
                Text(text = "MONTH: JULY")
                Spacer(modifier = modifier.padding(7.dp))
                CalendarMonthDetails()
                Text(text = "SCHEDULE:")
                Spacer(modifier = modifier.padding(7.dp))
                TeachersSchedule()

            }
        }
    }
}

@Composable
fun CalendarMonthDetails(modifier: Modifier = Modifier){
    Row (modifier = modifier
        .fillMaxWidth()
        .height(200.dp), horizontalArrangement = Arrangement.SpaceEvenly){
        Column {
            Text(text = "Mon", fontWeight = FontWeight.Bold)
            Text("  ")
            Text("07")
            Text("14")
            Text("21")
            Text("28")
        }
        Column {
            Text(text = "Tue", fontWeight = FontWeight.Bold)
            Text("01")
            Text("08")
            Text("15")
            Text("22")
            Text("29")
        }
        Column {
            Text(text = "Wed", fontWeight = FontWeight.Bold)
            Text("02")
            Text("09")
            Text("16")
            Text("23")
            Text("30")
        }
        Column {
            Text(text = "Thu", fontWeight = FontWeight.Bold)
            Text("02")
            Text("10")
            Text("17")
            Text("24")
            Text("31")
        }
        Column {
            Text(text = "Fri", fontWeight = FontWeight.Bold)
            Text("04")
            Text("11")
            Text("18")
            Text("25")
            Text("  ")
        }
        Column {
            Text(text = "Sat", fontWeight = FontWeight.Bold)
            Text("05")
            Text("12")
            Text("19")
            Text("26")
            Text("  ")
        }
        Column {
            Text(text = "Sun", fontWeight = FontWeight.Bold)
            Text("06")
            Text("13")
            Text("20")
            Text("22")
            Text("  ")
        }
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
