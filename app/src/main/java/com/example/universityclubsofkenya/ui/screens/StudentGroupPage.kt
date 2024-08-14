package com.example.universityclubsofkenya.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.ui.reusables.Group
import com.example.universityclubsofkenya.ui.theme.UniversityClubsOfKenyaTheme

@Composable
fun StudentGroup(modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    Scaffold(topBar = {Group(onGroupButtonClicked = { /*TODO*/ })},
        bottomBar = {
        Row( modifier = modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.Center){
            TextField(value = "Add Text", onValueChange = {/*TODO*/})
        }
    }) {innerPadding ->
        Column(modifier = modifier
            .padding(innerPadding)
            .fillMaxWidth()
            .verticalScroll(scrollState)) {
            ElevatedCard {
                Text("Hello, Welcome to the multimedia university group")
                Text("Where will we be meeting ?")
                Text("In the computer lab A06 in Block A")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentGroupPagePreview(){
    UniversityClubsOfKenyaTheme {
        StudentGroup()
    }
}
