package com.keo.source.base

import com.keo.source.base.dto.Genre

interface GenreRepository {
    suspend fun getGenres(): List<Genre>
}