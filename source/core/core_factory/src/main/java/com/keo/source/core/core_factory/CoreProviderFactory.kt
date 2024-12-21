package com.keo.source.core.core_factory

import com.keo.source.core.core_api.NetworkProvider
import com.keo.source.core.core_impl.DaggerNetworkComponent

object CoreProviderFactory {
    fun createNetworkBuilder() : NetworkProvider{
        return DaggerNetworkComponent.builder().build()
    }
}