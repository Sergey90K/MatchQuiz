package com.seerhii.kurochka.mytestapp.network

import retrofit2.http.GET

interface QuizApiService {
    @GET("address")
    suspend fun getSamData(): List<String>
}