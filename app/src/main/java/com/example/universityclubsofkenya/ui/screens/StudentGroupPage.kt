package com.example.universityclubsofkenya.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.R
import com.example.universityclubsofkenya.data.models.GroupMessage
import com.example.universityclubsofkenya.ui.reusables.Group
import com.example.universityclubsofkenya.ui.viewModels.GroupViewModel

@Composable
fun StudentGroup(groupViewModel: GroupViewModel, groupMessages: List<GroupMessage>, modifier: Modifier = Modifier){

    var message by remember { mutableStateOf("") }
    var studentGroupMessageState by remember { mutableStateOf(false) }

    if(studentGroupMessageState){
        LaunchedEffect(groupViewModel) {
            groupViewModel.updateStudentChatsChanged(groupViewModel.postAndGetStudentChats(GroupMessage(message, "Kees")).await())
            message = ""
            studentGroupMessageState = false
        }
    }
    val scrollState = rememberScrollState()
    Scaffold(topBar = {Group(onGroupButtonClicked = { /*TODO*/ })},
        bottomBar = {
        Row( modifier = modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.Center){
            TextField(value = message, onValueChange = { message = it }, label = { Text(text = "Add Message")})
            IconButton(onClick = {studentGroupMessageState = true}) {
                Image(painter = painterResource(R.drawable.send), contentDescription = "send")
            }
        }
    }) {innerPadding ->
        Column(modifier = modifier
            .padding(innerPadding)
            .fillMaxWidth()
            .verticalScroll(scrollState)) {
            Column(modifier = modifier.padding(10.dp)){

                for(groupMessage in groupMessages){
                    Column (modifier = modifier.padding(vertical = 10.dp)) {
                        ElevatedCard{
                            Column(modifier = modifier.padding(5.dp)){
                                Text(groupMessage.body)
                            }
                        }
                        Card {
                            Column(modifier = modifier.padding(5.dp)){
                                Text(groupMessage.username)
                            }
                        }
                    }
                }
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun StudentGroupPagePreview(){
    UniversityClubsOfKenyaTheme {
        StudentGroup()
    }
}*/
