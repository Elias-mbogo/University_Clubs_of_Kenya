package com.example.universityclubsofkenya.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.data.models.ChapterName
import com.example.universityclubsofkenya.ui.theme.Typography

@Composable
fun CourseScreen(modifier: Modifier = Modifier){
    CourseTitle()
}

@Composable
fun CourseTitle(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(30.dp)
        .size(150.dp)){
        ElevatedCard(onClick = { /*TODO*/ }) {
            Column(modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 20.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "KENYAWEB",  style = Typography.titleLarge )
                Text(text = "COURSE", style = Typography.titleLarge)
            }
        }
    }
}

@Composable
fun Course(chapters: List<ChapterName>, modifier: Modifier = Modifier){
    Column {
        Row(modifier = modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Kotlin", style = Typography.titleMedium)
        }

        Column(
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            for (chapter in chapters){
                Text(text = chapter.name)
                HorizontalDivider()
            }
        }

    }
}