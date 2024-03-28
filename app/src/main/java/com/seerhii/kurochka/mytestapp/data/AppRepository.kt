package com.seerhii.kurochka.mytestapp.data

import com.seerhii.kurochka.mytestapp.network.QuizApiService

interface AppRepository {
    suspend fun getSamData(): List<String>
}

class NetworkAppRepository(private val quizApiService: QuizApiService) : AppRepository {
    override suspend fun getSamData(): List<String> {
        return quizApiService.getSamData()
    }
}