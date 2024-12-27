package com.keo.source.core.core_api

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatchersProvider {
    @IODispatcher
    fun getIO() : CoroutineDispatcher
    @DefaultDispatcher
    fun getDefault() : CoroutineDispatcher
    @MainDispatcher
    fun getMain() : CoroutineDispatcher
}