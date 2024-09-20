package com.example.universityclubsofkenya.data

import com.example.universityclubsofkenya.data.repositories.CourseRepository
import com.example.universityclubsofkenya.data.repositories.ExamRepository
import com.example.universityclubsofkenya.data.repositories.GroupRepository
import com.example.universityclubsofkenya.data.repositories.NetworkCourseRepository
import com.example.universityclubsofkenya.data.repositories.NetworkExamRepository
import com.example.universityclubsofkenya.data.repositories.NetworkGroupRepository
import com.example.universityclubsofkenya.data.repositories.NetworkUsersRepository
import com.example.universityclubsofkenya.data.repositories.UsersRepository
import com.example.universityclubsofkenya.network.CourseApiService
import com.example.universityclubsofkenya.network.ExamApiService
import com.example.universityclubsofkenya.network.GroupApiService
import com.example.universityclubsofkenya.network.UsersApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

interface AppContainer{
    val usersRepository: UsersRepository
    val courseRepository: CourseRepository
    val groupRepository: GroupRepository
    val examRepository: ExamRepository
}

class DefaultAppContainer: AppContainer {
    private val baseUrl = "https://7e31-194-201-253-246.ngrok-free.app"
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

    private val courseRetrofitService: CourseApiService by lazy{
        retrofit.create(CourseApiService::class.java)
    }

    override val courseRepository: CourseRepository by lazy{
        NetworkCourseRepository(courseRetrofitService)
    }

    private val groupRetrofitService: GroupApiService by lazy{
        retrofit.create(GroupApiService::class.java)
    }

    override val groupRepository: GroupRepository by lazy {
        NetworkGroupRepository(groupRetrofitService)
    }

    private val examRetrofitService: ExamApiService by lazy{
        retrofit.create(ExamApiService::class.java)
    }

    override val examRepository: ExamRepository by lazy{
        NetworkExamRepository(examRetrofitService)
    }

}