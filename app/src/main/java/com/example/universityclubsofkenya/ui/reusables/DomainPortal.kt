package com.example.universityclubsofkenya.ui.reusables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.universityclubsofkenya.R
import com.example.universityclubsofkenya.ui.StudentGroupChat

@Composable
fun Portal(studentGroupPageState: Boolean, onStudentGroupPageClicked: (Boolean) -> Unit,  navController: NavController, modifier: Modifier = Modifier){
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = painterResource(id = R.drawable.newspaper), contentDescription = "newspaper")
        }

        ElevatedButton(onClick = { /*TODO*/ }) {
            Row(modifier = modifier.padding(horizontal = 5.dp)) {
                Image(painter = painterResource(id = R.drawable.shop), contentDescription = "shop" )
            }
            Row {
                Text(text = "SOFTWARE")
                Text("M", color = Blue)
            }

        }

        IconButton(onClick = { onStudentGroupPageClicked(!studentGroupPageState)}) {
            Image(painter = painterResource(id = R.drawable.chat), contentDescription = "chat" )
        }
    }
}
