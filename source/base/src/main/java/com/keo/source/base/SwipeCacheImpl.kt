package com.keo.source.base

import com.keo.source.core.core_api.Cache
import com.keo.source.core.core_api.CacheProvider
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

class SwipeCacheImpl @Inject constructor() : Cache<DataType, List<@JvmSuppressWildcards Any>>,
    CacheProvider<DataType, List<@JvmSuppressWildcards Any>> {
    private val cache = ConcurrentHashMap<DataType, List<Any>>()

    override fun get(key: DataType): List<Any>? = cache[key]

    override fun put(key: DataType, value: List<Any>) {
        cache[key] = value
    }

    override fun invalidate(key: DataType) {
        cache.remove(key)
    }

    override fun invalidateAll() {
        cache.clear()
    }

    override fun provideCache(): Cache<DataType, List<Any>> = this
}