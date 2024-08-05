package com.example.universityclubsofkenya.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.R
import com.example.universityclubsofkenya.ui.reusables.Portal
import com.example.universityclubsofkenya.ui.theme.UniversityClubsOfKenyaTheme


@Composable
fun StudentDomain(modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    Column (modifier = modifier
        .padding(vertical = 20.dp)
        .verticalScroll(scrollState)){
        Portal()
        StudentBusinessRelations()
        StudentSchedules()
    }
}

@Composable
fun StudentBusinessRelations(modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(vertical = 10.dp, horizontal = 20.dp)) {
        val currentProgress by remember { mutableFloatStateOf(17f) }
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
                    .padding(10.dp)
                    .width(150.dp)){
                    Column{
                        Text(text = "SAFARICOM")
                        HorizontalDivider()
                    }
                    LinearProgressIndicator(progress = { currentProgress })
                    Text(text = "Participant")
                }
                Column(modifier = modifier.padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(R.drawable.friend),
                        contentDescription = "friend" ,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .size(40.dp)
                            .clip(CircleShape))
                }
            }
        }

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Image(painter = painterResource(R.drawable.kenyaweb),
                contentDescription = "safaricom",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape))
            Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
                Column (modifier = modifier
                    .padding(10.dp)
                    .width(150.dp)){
                    Column{
                        Text(text = "KENYAWEB")
                        HorizontalDivider()
                    }
                    LinearProgressIndicator(progress = { currentProgress })
                    Text(text = "Potential")
                }
                Column(modifier = modifier.padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(R.drawable.friend),
                        contentDescription = "friend" ,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .size(40.dp)
                            .clip(CircleShape))
                }
            }
        }

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Image(painter = painterResource(R.drawable.presta),
                contentDescription = "presta technologies",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape))
            Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
                Column (modifier = modifier
                    .padding(10.dp)
                    .width(150.dp)){
                    Column{
                        Text(text = "PRESTA")
                        HorizontalDivider()
                    }
                    LinearProgressIndicator(progress = { currentProgress })
                    Text(text = "Participant")
                }
                Column(modifier = modifier.padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(R.drawable.friend),
                        contentDescription = "friend" ,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .size(40.dp)
                            .clip(CircleShape))
                }
            }
        }

    }
}

@Composable
fun StudentSchedules(modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    Column (modifier = modifier
        .padding(vertical = 10.dp, horizontal = 20.dp)
        .height(300.dp)){
        Card {

            Column(modifier = modifier
                .fillMaxWidth().verticalScroll(scrollState)) {
                Text(text ="SCHEDULES: ")
                Spacer(modifier = modifier.padding(10.dp))
                Text(text = "24/01/2024: Funding")
                HorizontalDivider()
                Text(text = "12/02/2024: Project Initialisation")
                HorizontalDivider()
                Text(text = "14/03/2024: Kenyaweb Seminar")
                HorizontalDivider()
                Text(text = "07/04/2024: Safaricom Test")
                HorizontalDivider()
                Text(text = "29/05/2024: Kenyattta University")
                HorizontalDivider()
                Text(text = "15/06/2024: Interschools Competitions")
                HorizontalDivider()
                Text(text = "09/07/2024: Kenyaweb Test")
                HorizontalDivider()
                Text(text = "01/08/2024: Presta Tours")
                HorizontalDivider()
                Text(text = "14/09/2024: Games")
                HorizontalDivider()
                Text(text = "20/01/2024: Safaricom Seminar")
                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentPagePreview() {
    UniversityClubsOfKenyaTheme {
        StudentDomain()
    }
}