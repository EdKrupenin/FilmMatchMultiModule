package com.keo.source.core.core_factory

import com.keo.source.core.core_api.CoroutineDispatchersProvider
import com.keo.source.core.core_api.NetworkProvider
import com.keo.source.core.core_impl.DaggerCoroutineDispatchersComponent
import com.keo.source.core.core_impl.DaggerNetworkComponent

object CoreProviderFactory {
    fun createNetworkBuilder() : NetworkProvider{
        return DaggerNetworkComponent.builder().build()
    }
    fun createCoroutineBuilder() : CoroutineDispatchersProvider {
        return DaggerCoroutineDispatchersComponent.builder().build()
    }
}