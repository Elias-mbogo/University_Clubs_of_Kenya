package com.example.universityclubsofkenya.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Usersz(
    val id: Int?,
    val username: String,
    val password: String,
    val enabled: Boolean
)
