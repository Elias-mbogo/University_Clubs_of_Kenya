package com.example.universityclubsofkenya.ui.reusables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SignInAccount(modifier: Modifier = Modifier, username: String, onUsernameChanged: (String) -> Unit,
                  password: String, onPasswordChanged: (String) -> Unit,
                  onUsersStateChanged: (Boolean) -> Unit, userDetails: Boolean)
{
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        OutlinedTextField(value = username, onValueChange = onUsernameChanged, modifier = modifier.padding(bottom = 15.dp), label = { Text("Username") })
        OutlinedTextField(value = password, onValueChange = onPasswordChanged, modifier = modifier.padding(bottom = 15.dp), label = { Text("Password") })
        Button(onClick = {onUsersStateChanged(!userDetails)}) {
            Text("Account")
        }
    }
}