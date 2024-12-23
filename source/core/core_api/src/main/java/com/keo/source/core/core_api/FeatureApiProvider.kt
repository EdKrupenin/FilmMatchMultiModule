package com.keo.source.core.core_api

import dagger.internal.Provider

typealias FeatureApiMap = Map<Class<*>, @JvmSuppressWildcards Provider<Any>>

interface FeatureApiProvider {
    fun featureApis(): FeatureApiMap
}