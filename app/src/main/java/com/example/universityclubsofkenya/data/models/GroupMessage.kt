package com.example.universityclubsofkenya.data.models

import kotlinx.serialization.Serializable

@Serializable
data class GroupMessage(
    val body: String,
    val username: String
)
