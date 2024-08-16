package com.example.universityclubsofkenya.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Users(
    val username: String,
    val password: String,
    val enabled: Boolean?
)
