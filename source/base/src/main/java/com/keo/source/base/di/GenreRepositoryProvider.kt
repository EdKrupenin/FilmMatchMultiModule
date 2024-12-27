package com.keo.source.base.di

import com.keo.source.base.GenreRepository

interface GenreRepositoryProvider {
    fun genreRepository(): GenreRepository
}