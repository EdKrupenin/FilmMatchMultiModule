package com.keo.source.core.core_api

import retrofit2.Retrofit

interface NetworkProvider {
    fun provideRetrofit() : Retrofit
}