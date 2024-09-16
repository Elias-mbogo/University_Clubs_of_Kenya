package com.example.universityclubsofkenya.ui.screens

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.R
import com.example.universityclubsofkenya.ui.reusables.Group
import com.example.universityclubsofkenya.ui.viewModels.ScheduleViewModel
import java.util.Calendar

@Composable
fun ExamScheduleScreen(scheduleViewModel: ScheduleViewModel, modifier: Modifier = Modifier){

    if(scheduleViewModel.dateDialogState){
        DatePickerComponent(dateState = scheduleViewModel.dateDialogState, onDateButtonCliked = {scheduleViewModel.dateDialogState = it})
    }
    if(scheduleViewModel.timeDialogState){
        TimePickerComponent(timeState = scheduleViewModel.timeDialogState, onTimeButtonCliked = {scheduleViewModel.timeDialogState = it})
    }

    Scaffold (
        topBar = { Group(onGroupButtonClicked = { /*TODO*/ }, groupName = "Kenyaweb") }
    ){innerPadding ->
        Column(modifier = modifier
            .padding(innerPadding)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())) {
            CurrentExamsPortal()
            NewExamsPortal(dateState = scheduleViewModel.dateDialogState, onDateIconCliked = {scheduleViewModel.dateDialogState = it},
                timeState = scheduleViewModel.timeDialogState, onTimeIconCliked = {scheduleViewModel.timeDialogState = it})
        }
    }
}

@Composable
fun CurrentExamsPortal(modifier: Modifier = Modifier){
    Card(modifier = modifier.padding(10.dp)) {
        Column(
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth()
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
}

//Function for creating a new exam for a business
@Composable
fun NewExamsPortal(dateState: Boolean, onDateIconCliked: (Boolean) -> Unit,
                   timeState: Boolean, onTimeIconCliked: (Boolean) -> Unit,
                   modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(10.dp). fillMaxWidth(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text("New Exam")
        Row {
            OutlinedTextField(value = "", onValueChange = {/*TODO*/}, label ={ Text("Date")})
            IconButton(onClick = {onDateIconCliked(!dateState)}) {
                Image(painter = painterResource(R.drawable.addition), contentDescription = "plus")
            }
        }
        Row {
            OutlinedTextField(value = "", onValueChange = {/*TODO*/}, label ={ Text("Start Time")})
            IconButton(onClick = {onTimeIconCliked(!timeState)}) {
                Image(painter = painterResource(R.drawable.addition), contentDescription = "plus")
            }
        }
        Row {
            OutlinedTextField(value = "", onValueChange = {/*TODO*/}, label ={ Text("End Time")})
            IconButton(onClick = {onTimeIconCliked(!timeState)}) {
                Image(painter = painterResource(R.drawable.addition), contentDescription = "plus")
            }
        }
        Row {
            OutlinedTextField(value = "", onValueChange = {/*TODO*/}, label ={ Text("Exam Name")})
            IconButton(onClick = {/*TODO*/}) {
                Image(painter = painterResource(R.drawable.addition), contentDescription = "plus")
            }
        }
        Button(onClick = {/*TODO*/}) {
            Text("Add Exam")
        }
    }
}

//Picking a date for the first input field
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerComponent(dateState: Boolean, onDateButtonCliked: (Boolean) -> Unit, modifier: Modifier = Modifier){
    val datePickerState = rememberDatePickerState()

    Column(modifier = modifier.padding(10.dp)){

        DatePickerDialog(onDismissRequest = { onDateButtonCliked(!dateState) },
            confirmButton = { /*TODO*/ },
            dismissButton = { /*TODO*/}) {
            DatePicker(datePickerState)
        }
    }
}

//Picking a time for the second  and third input field
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerComponent(timeState: Boolean, onTimeButtonCliked: (Boolean) -> Unit, modifier: Modifier = Modifier){
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime[Calendar.HOUR_OF_DAY],
        initialMinute = currentTime[Calendar.MINUTE],
        is24Hour = true
    )

    TimePickerDialog(onDismiss = { onTimeButtonCliked(!timeState) }) {
        TimePicker(state = timePickerState)
    }
}

//Dialog for picking a time
@Composable
fun TimePickerDialog(onDismiss: () -> Unit, content: @Composable () -> Unit){
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = {/*TODO*/}){
                Text("Dismiss")
            }
        },
        confirmButton = {
            TextButton(onClick = {/*TODO*/}){
                Text("Ok")
            }
        },
        text = { content() }
    )

}