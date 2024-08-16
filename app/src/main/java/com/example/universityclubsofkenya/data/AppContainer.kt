package com.example.universityclubsofkenya.data

import com.example.universityclubsofkenya.data.repositories.NetworkUsersRepository
import com.example.universityclubsofkenya.data.repositories.UsersRepository
import com.example.universityclubsofkenya.network.UsersApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

interface AppContainer{
    val usersRepository: UsersRepository
}

class DefaultAppContainer: AppContainer {
    private val baseUrl = "https://f56d-194-201-253-246.ngrok-free.app"
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val usersRetrofitService: UsersApiService by lazy{
        retrofit.create(UsersApiService::class.java)
    }

    override val usersRepository: UsersRepository by lazy{
        NetworkUsersRepository(usersRetrofitService)
    }

}