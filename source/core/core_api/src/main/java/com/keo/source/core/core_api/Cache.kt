package com.keo.source.core.core_api

interface Cache<K, V> {
    fun get(key: K): V?
    fun put(key: K, value: V)
    fun invalidate(key: K)
    fun invalidateAll()
}