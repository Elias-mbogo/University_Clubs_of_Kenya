package com.example.universityclubsofkenya.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.R
import com.example.universityclubsofkenya.data.models.ChapterName
import com.example.universityclubsofkenya.ui.reusables.Portal
import org.jetbrains.annotations.ApiStatus.Experimental

@Composable
fun Business(chapters: List<ChapterName>, modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    Column(modifier = modifier.verticalScroll(scrollState)) {
        Portal()
        UniversityRelations()
        Assessment(chapters)

    }
}

@Composable
fun UniversityRelations(modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(5.dp)){
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Image(painter = painterResource(R.drawable.mmu),
                contentDescription = "multimedia university",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape))
            Column(modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Text(text = "MULTIMEDIA UNIVERSITY")
                }
                Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "Potential: 2")
                    Text(text = "Participants: 10")
                }

            }
        }

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Image(painter = painterResource(R.drawable.nazarene),
                contentDescription = "nazarene university",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape))
            Column(modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Text(text = "NAZARENE UNIVERSITY")
                }
                Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "Potential: 7")
                    Text(text = "Participants: 20")
                }

            }
        }

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Image(painter = painterResource(R.drawable.cooperative),
                contentDescription = "Cooperative university",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape))
            Column(modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    Text(text = "COOPERATIVE UNIVERSITY")
                }
                Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "Potential: 5")
                    Text(text = "Participants: 15")
                }

            }
        }
    }
}

@Composable
fun Assessment(chapters: List<ChapterName>, modifier: Modifier = Modifier){
    Column (modifier = modifier.padding(10.dp)){
        Card{
            val scrollState = rememberScrollState()
            val scrollState2 = rememberScrollState()
            Column(modifier = modifier
                .padding(10.dp)) {
                Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(text = "YEAR: 2024")
                }
                Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "COURSE:")
                    Row{
                       IconButton(onClick = { /*TODO*/ }) {
                           Icon(painter = painterResource(R.drawable.addition), contentDescription = "add")
                       }
                        Text(text = "Add Chapter")
                    }
                }
                Spacer(modifier = modifier.padding(7.dp))
                Course(chapters, scrollState)
                Text(text = "EXAMS:")
                Spacer(modifier = modifier.padding(7.dp))
                Exams(scrollState2)

            }
        }
    }
}

@Composable
fun Course(chapters: List<ChapterName>, scrollState: ScrollState, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(150.dp)
            .verticalScroll(scrollState)
    ) {
        for (chapter in chapters){
            Text(text = chapter.name)
            HorizontalDivider()
        }
    }
}

@Composable
fun Exams(scrollState: ScrollState, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(150.dp)
            .verticalScroll(scrollState)
    ) {
        Text(text = "24/01/2024: Multimedia University")
        Text(text = "12/02/2024: Cooperative University")
        Text(text = "14/03/2024: African Nazarene University")
        Text(text = "07/04/2024: Multimedia University")
        Text(text = "29/05/2024: Kenyattta University")
        Text(text = "15/06/2024: Nairobi University")
        Text(text = "09/07/2024: Machakos University")
        Text(text = "01/08/2024: Cooperative University")
        Text(text = "14/09/2024: Nairobi University")
        Text(text = "20/01/2024: African Nazarene University")
    }
}

@Composable
fun AddChapterDialogBox(){
    AlertDialog(
        onDismissRequest = {/*TODO*/},
        title = { Text("Kotlin Language")},
        text = { TextField(value = "Add Chapter", onValueChange = {/*TODO*/})},
        confirmButton = {/*TODO*/},
        dismissButton = {/*TODO*/}
    )
}
/*
@Preview(showBackground = true)
@Composable
fun BusinessPagePreview() {
    UniversityClubsOfKenyaTheme {
        Business()
    }
}*/
