package com.example.universityclubsofkenya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.universityclubsofkenya.ui.Business
import com.example.universityclubsofkenya.ui.ClubApp
import com.example.universityclubsofkenya.ui.reusables.Portal
import com.example.universityclubsofkenya.ui.theme.UniversityClubsOfKenyaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniversityClubsOfKenyaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ClubApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UniversityClubsOfKenyaTheme {
        ClubApp()
    }
}*/
