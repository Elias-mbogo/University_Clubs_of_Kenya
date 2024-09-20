package com.example.universityclubsofkenya.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.universityclubsofkenya.R
import com.example.universityclubsofkenya.ui.reusables.Group
import com.example.universityclubsofkenya.ui.viewModels.ScheduleViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamScheduleScreen(scheduleViewModel: ScheduleViewModel, modifier: Modifier = Modifier){

    if(scheduleViewModel.dateDialogState){
        DatePickerComponent(dateState = scheduleViewModel.dateDialogState, onDateButtonClicked = {scheduleViewModel.dateDialogState = it},
            onDateSelected = {scheduleViewModel.selectedDate = it})
    }
    if(scheduleViewModel.startTimeDialogState){
        TimePickerComponent(timeState = scheduleViewModel.startTimeDialogState, onTimeButtonClicked = {scheduleViewModel.startTimeDialogState = it},
            onTimeSelected = {scheduleViewModel.selectedStartTime = it})
    }
    if(scheduleViewModel.endTimeDialogState){
        TimePickerComponent(timeState = scheduleViewModel.endTimeDialogState, onTimeButtonClicked = {scheduleViewModel.endTimeDialogState = it},
            onTimeSelected = {scheduleViewModel.selectedEndTime = it})
    }

    if(scheduleViewModel.examState){
        LaunchedEffect(scheduleViewModel) {
            scheduleViewModel.updateExamDetailsChanged(scheduleViewModel.postAndGetExamDetails().await())
            scheduleViewModel.selectedDate = ""
            scheduleViewModel.selectedStartTime = ""
            scheduleViewModel.selectedEndTime = ""
            scheduleViewModel.examName = ""
            scheduleViewModel.examState = false
        }
    }

    Scaffold (
        topBar = { Group(onGroupButtonClicked = { /*TODO*/ }, groupName = "Kenyaweb") }
    ){innerPadding ->
        Column(modifier = modifier
            .padding(innerPadding)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())) {
            CurrentExamsPortal()
            NewExamsPortal(scheduleViewModel = scheduleViewModel,
                dateState = scheduleViewModel.dateDialogState, onDateIconClicked = {scheduleViewModel.dateDialogState = it},
                startTimeState = scheduleViewModel.startTimeDialogState, onStartTimeIconClicked = {scheduleViewModel.startTimeDialogState = it},
                endTimeState = scheduleViewModel.endTimeDialogState, onEndTimeIconClicked = {scheduleViewModel.endTimeDialogState = it},
                examName = scheduleViewModel.examName, onExamNameChanged = {scheduleViewModel.updateExamName(it)},
                examState = scheduleViewModel.examState, onExamButtonClicked = {scheduleViewModel.examState = it})
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
fun NewExamsPortal(scheduleViewModel: ScheduleViewModel,
                   dateState: Boolean, onDateIconClicked: (Boolean) -> Unit,
                   startTimeState: Boolean, onStartTimeIconClicked: (Boolean) -> Unit,
                   endTimeState: Boolean, onEndTimeIconClicked: (Boolean) -> Unit,
                   examName: String, onExamNameChanged: (String) -> Unit,
                   examState: Boolean, onExamButtonClicked: (Boolean) -> Unit,
                   modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(10.dp). fillMaxWidth(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text("New Exam")
        Row {
            OutlinedTextField(value = scheduleViewModel.selectedDate ?: "", onValueChange = {/*TODO*/}, label ={ Text("Date")})
            IconButton(onClick = {onDateIconClicked(!dateState)}) {
                Image(painter = painterResource(R.drawable.addition), contentDescription = "plus")
            }
        }
        Row {
            OutlinedTextField(value = scheduleViewModel.selectedStartTime ?: "", onValueChange = {/*TODO*/}, label ={ Text("Start Time")})
            IconButton(onClick = {onStartTimeIconClicked(!startTimeState)}) {
                Image(painter = painterResource(R.drawable.addition), contentDescription = "plus")
            }
        }
        Row {
            OutlinedTextField(value = scheduleViewModel.selectedEndTime ?: "", onValueChange = {/*TODO*/}, label ={ Text("End Time")})
            IconButton(onClick = {onEndTimeIconClicked(!endTimeState)}) {
                Image(painter = painterResource(R.drawable.addition), contentDescription = "plus")
            }
        }
        Row {
            OutlinedTextField(value = examName, onValueChange = onExamNameChanged, label ={ Text("Exam Name")})
            IconButton(onClick = {onExamButtonClicked(!examState)}) {
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
fun DatePickerComponent(dateState: Boolean, onDateButtonClicked: (Boolean) -> Unit,
                        onDateSelected: (String?) -> Unit, modifier: Modifier = Modifier) {
    val datePickerState = rememberDatePickerState()
    Column(modifier = modifier.padding(10.dp)){

        DatePickerDialog(onDismissRequest = { onDateButtonClicked(!dateState) },
            confirmButton = {
                TextButton(onClick = {
                    val date = Date(datePickerState.selectedDateMillis!!)
                    val formattedDate = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(date)
                    onDateSelected(formattedDate.toString())
                    onDateButtonClicked(!dateState)
                }) {
                    Text("Ok")
                }

            },
            dismissButton = {
                TextButton(onClick = {
                    onDateButtonClicked(!dateState)
                }) {
                    Text("Dismiss")
                }
            }) {
            DatePicker(datePickerState)
        }
    }
}

//Picking a time for the second  and third input field
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerComponent(timeState: Boolean, onTimeButtonClicked: (Boolean) -> Unit, onTimeSelected: (String?) -> Unit, modifier: Modifier = Modifier){
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime[Calendar.HOUR_OF_DAY],
        initialMinute = currentTime[Calendar.MINUTE],
        is24Hour = false
    )

    TimePickerDialog(timeState = timeState, onTimeButtonClicked = onTimeButtonClicked,
        timePickerState = timePickerState, onTimeSelected = onTimeSelected) {
        TimePicker(state = timePickerState)
    }
}

//Dialog for picking a time
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialog(timeState: Boolean, onTimeButtonClicked: (Boolean) -> Unit,
                     timePickerState: TimePickerState, onTimeSelected: (String?) -> Unit, content: @Composable () -> Unit){
    AlertDialog(
        onDismissRequest = {onTimeButtonClicked(!timeState)},
        dismissButton = {
            TextButton(onClick = {onTimeButtonClicked(!timeState)}){
                Text("Dismiss")
            }
        },
        confirmButton = {
            TextButton(onClick = {
                val time = timePickerState.hour
                val minute = timePickerState.minute
                val formattedTime = String.format("%02d:%02d", time, minute)
                onTimeSelected(formattedTime)
                onTimeButtonClicked(!timeState)}
            ){
                Text("Ok")
            }
        },
        text = { content() }
    )
}