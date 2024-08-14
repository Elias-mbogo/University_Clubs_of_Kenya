package com.example.universityclubsofkenya.data.repositories

import com.example.universityclubsofkenya.data.models.Usersz
import com.example.universityclubsofkenya.network.UsersApiService

interface UserszRepository {
    suspend fun getUsers(users: Usersz): Usersz
}

class NetworkUserszRepository( private val usersApiService: UsersApiService): UserszRepository{
    override suspend fun getUsers(users: Usersz): Usersz {
        return usersApiService.getUser(users)
    }
}