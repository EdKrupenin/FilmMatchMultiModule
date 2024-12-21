package com.keo.source.home.home_api

import com.keo.source.core.core_api.FeatureApi

interface HomeFeatureApi : FeatureApi {
    fun homeRoute(): String
}