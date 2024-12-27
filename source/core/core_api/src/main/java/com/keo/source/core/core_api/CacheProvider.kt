package com.keo.source.core.core_api

interface CacheProvider<K, V> {
    fun provideCache(): Cache<K, V>
}