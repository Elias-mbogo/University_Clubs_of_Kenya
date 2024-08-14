package com.example.universityclubsofkenya.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.R
import com.example.universityclubsofkenya.ui.theme.UniversityClubsOfKenyaTheme

@Composable
fun Partcipants(modifier: Modifier = Modifier){
    val currentProgress by remember { mutableFloatStateOf(17f) }

    Column(modifier = modifier.padding(vertical = 50.dp)) {
        Row (modifier = modifier.fillMaxWidth()){
            Image(painter = painterResource(R.drawable.male),
                contentDescription = "male" ,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(16.dp)))
            Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Column {
                    Text(text = "Elias Mwangi")
                    LinearProgressIndicator(progress = { currentProgress })
                    Text(text = "Participant")
                }

                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(R.drawable.friend),
                        contentDescription = "friend" ,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .size(40.dp)
                            .clip(CircleShape))
                }
            }
        }
        HorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessParticipantsPagePreview() {
    UniversityClubsOfKenyaTheme {
        Partcipants()
    }
}