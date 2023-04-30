package ru.anb.fitnesskit.api

import retrofit2.Response
import retrofit2.http.GET
import ru.anb.fitnesskit.data.Training

interface ApiService {

    @GET("schedule/get_v3/?club_id=2")
    suspend fun getTrainingList(): Response<List<Training>>
}