package com.example.universityclubsofkenya.data.repositories

import com.example.universityclubsofkenya.data.models.GroupMessage
import com.example.universityclubsofkenya.network.GroupApiService

interface GroupRepository {
    suspend fun getStudentChats(): List<GroupMessage>
    suspend fun postAndGetStudentChats(groupMessage: GroupMessage): List<GroupMessage>
}

class NetworkGroupRepository(
    val groupApiService: GroupApiService
): GroupRepository{
    override suspend fun getStudentChats(): List<GroupMessage> {
        return groupApiService.getStudentChats()
    }

    override suspend fun postAndGetStudentChats(groupMessage: GroupMessage): List<GroupMessage> {
        return groupApiService.postAndGetStudentChats(groupMessage)
    }
}
