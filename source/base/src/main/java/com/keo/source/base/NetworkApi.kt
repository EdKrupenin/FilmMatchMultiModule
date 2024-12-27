package com.keo.source.base

import com.keo.source.base.dto.Genre
import retrofit2.http.GET

interface NetworkApi {
    @GET("/filters")
    suspend fun getGenres(): List<Genre>
}