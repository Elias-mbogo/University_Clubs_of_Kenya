package com.example.universityclubsofkenya.ui.reusables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Group(onGroupButtonClicked: () -> Unit, modifier: Modifier = Modifier){
    Row(modifier= modifier
        .fillMaxWidth()
        .padding(30.dp), horizontalArrangement = Arrangement.Center ){
        ElevatedButton(onClick = onGroupButtonClicked) {
            Text(text ="Multimedia")
        }
    }
}