package com.example.universityclubsofkenya.data.repositories

import com.example.universityclubsofkenya.data.models.TeacherResource
import com.example.universityclubsofkenya.data.models.Users
import com.example.universityclubsofkenya.network.UsersApiService

interface UsersRepository {
    suspend fun getUsers(users: Users): Users
    suspend fun getTeachersResource(): TeacherResource
}

class NetworkUsersRepository( private val usersApiService: UsersApiService): UsersRepository{
    override suspend fun getUsers(users: Users): Users {
        return usersApiService.getUser(users)
    }

    override suspend fun getTeachersResource(): TeacherResource {
        return usersApiService.getTeachersResource()
    }
}