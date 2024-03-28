package com.seerhii.kurochka.mytestapp.data

import com.seerhii.kurochka.mytestapp.network.QuizApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val appRepository: AppRepository
}

class DefaultAppContainer() : AppContainer {
    private val baseUrl = "https://adres"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: QuizApiService by lazy {
        retrofit.create(QuizApiService::class.java)
    }
    override val appRepository: AppRepository by lazy {
        NetworkAppRepository(retrofitService)
    }
}