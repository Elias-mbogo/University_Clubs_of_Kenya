package com.example.universityclubsofkenya.ui.screens

import android.app.Activity
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.R
import com.example.universityclubsofkenya.data.models.ChapterName
import com.example.universityclubsofkenya.data.models.GroupMessage
import com.example.universityclubsofkenya.ui.viewModels.ExpertViewModel
import com.example.universityclubsofkenya.ui.viewModels.uiStates.ExpertUiState

@Composable
fun Business(expertViewModel: ExpertViewModel, expertUiState: ExpertUiState,
             modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    Column(modifier = modifier.verticalScroll(scrollState)) {
//        Portal()
        UniversityRelations()
        Assessment(newChapterState = expertViewModel.newChapterState,
            onChapterButtonClicked = {expertViewModel.newChapterState = it}, chapters = expertUiState.chapters)
        if(expertViewModel.newChapterState){
            AddChapterDialogBox(
                chapterDoneState = expertViewModel.chapterDoneState,
                onChapterDoneButtonClicked = {expertViewModel.chapterDoneState = it},
                newChapterState = expertViewModel.newChapterState,
                onChapterButtonClicked = {expertViewModel.newChapterState = it},
                chapter = expertViewModel.chapter, onChapterChanged = {expertViewModel.onChapterDetailsChanged(it)})

            if(expertViewModel.chapterDoneState){
                LaunchedEffect(expertViewModel) {
                    expertViewModel.updateChaptersChanged(expertViewModel.addChapters(expertViewModel.chapter).await())
                    expertViewModel.chapterDoneState = false
                }
                expertViewModel.newChapterState = false
            }
        }

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
fun Assessment(newChapterState: Boolean, onChapterButtonClicked: (Boolean) -> Unit,
               chapters: List<ChapterName>, modifier: Modifier = Modifier){

    Column (modifier = modifier.padding(10.dp)){
        Card{
            val scrollState = rememberScrollState()
            val scrollState2 = rememberScrollState()
            Column(modifier = modifier
                .padding(10.dp)) {
                Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(text = "YEAR: 2024")
                }
                Column(modifier = modifier.fillMaxWidth(),
                    horizontalAlignment =  Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    Text(text = "COURSE:")
                    Button(onClick = {onChapterButtonClicked(!newChapterState)} ) {
                        Text("Add Chapter")
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
fun AddChapterDialogBox(chapterDoneState: Boolean, onChapterDoneButtonClicked: (Boolean) -> Unit,
                        newChapterState: Boolean, onChapterButtonClicked: (Boolean) -> Unit,  chapter: String,
                        onChapterChanged: (String) -> Unit, modifier: Modifier = Modifier){
    val activity = (LocalContext.current as Activity)

    @OptIn(ExperimentalMaterial3Api::class)
    AlertDialog(
        onDismissRequest = {onChapterButtonClicked(!newChapterState)},
        title = { Text("Kotlin Language")},
        text = { TextField(value = chapter, onValueChange = onChapterChanged, label = {Text("Add Title")})},
        confirmButton = {
            TextButton(onClick = {onChapterDoneButtonClicked(!chapterDoneState)}) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = {onChapterButtonClicked(!newChapterState)}) {
                Text("Dismiss")
            }
        }
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
